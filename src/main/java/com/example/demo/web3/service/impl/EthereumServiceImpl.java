package com.example.demo.web3.service.impl;

import com.example.demo.web3.contract.ContaCorrente; // wrapper gerado do contrato
import com.example.demo.web3.service.EthereumService;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class EthereumServiceImpl implements EthereumService {

    private final Web3j web3j;
    private final String chavePrivada;
    private final Credentials credentials;

    public EthereumServiceImpl(Web3j web3j) {
        this.web3j = web3j;
        this.chavePrivada = System.getenv("PRIVATE_KEY");
        if (this.chavePrivada == null || this.chavePrivada.isEmpty()) {
            throw new RuntimeException("Variável de ambiente PRIVATE_KEY não definida!");
        }
        this.credentials = Credentials.create(chavePrivada);
    }

    public String getClientVersion() throws IOException {
        return web3j.web3ClientVersion().send().getWeb3ClientVersion();
    }

    // Carrega o contrato usando RawTransactionManager
    private ContaCorrente carregarContrato(String contratoAddress) {
        TransactionManager txManager = new RawTransactionManager(web3j, credentials);
        return ContaCorrente.load(
                contratoAddress,
                web3j,
                txManager,
                new DefaultGasProvider()
        );
    }

    // Deposita valor no contrato (função payable)
    public String depositar(String contratoAddress, BigDecimal valorEth) throws Exception {
        ContaCorrente contrato = carregarContrato(contratoAddress);

        // Converte o valor em Ether para Wei
        BigInteger valorWei = Convert.toWei(valorEth, Convert.Unit.ETHER).toBigInteger();

        // Chama o método depositar do contrato, passando o valor em Wei
        TransactionReceipt receipt = contrato.depositar(valorWei).send();

        return receipt.getTransactionHash();
    }

    // Consulta saldo do contrato
    public BigDecimal consultarSaldo(String contratoAddress) throws Exception {
        ContaCorrente contrato = carregarContrato(contratoAddress);
        BigInteger saldoWei = contrato.consultarSaldo().send();
        return Convert.fromWei(new BigDecimal(saldoWei), Convert.Unit.ETHER);
    }

    // Saca valor do contrato
    public String sacar(String contratoAddress, BigDecimal valorEth) throws Exception {
        ContaCorrente contrato = carregarContrato(contratoAddress);
        BigInteger valorWei = Convert.toWei(valorEth, Convert.Unit.ETHER).toBigInteger();

        return contrato.sacar(valorWei).send().getTransactionHash();
    }
    @Override
    public String transferir(String fromPrivateKey, String toAddress, BigDecimal valorEth) throws Exception {
        Credentials fromCredentials = Credentials.create(fromPrivateKey);

        // 1️⃣ Consulta saldo da conta de origem
        BigInteger saldoWei = web3j.ethGetBalance(fromCredentials.getAddress(),
                        org.web3j.protocol.core.DefaultBlockParameterName.LATEST)
                .send()
                .getBalance();
        BigDecimal saldoEth = Convert.fromWei(new BigDecimal(saldoWei), Convert.Unit.ETHER);

        // 2️⃣ Converte valor a transferir para Wei
        BigInteger valorWei = Convert.toWei(valorEth, Convert.Unit.ETHER).toBigInteger();

        // 3️⃣ Cria uma transação "fake" para estimar o gas
        org.web3j.protocol.core.methods.request.Transaction tx = org.web3j.protocol.core.methods.request.Transaction.createEtherTransaction(
                fromCredentials.getAddress(),
                null, // nonce, null = Web3j define automaticamente
                null, // gasPrice, null = Web3j define automaticamente
                null, // gasLimit, null para estimar
                toAddress,
                valorWei
        );

        BigInteger gasLimitEstimado = web3j.ethEstimateGas(tx).send().getAmountUsed();

        // 4️⃣ Consulta gasPrice atual
        BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();

        // 5️⃣ Calcula total necessário: valor + (gas * gasPrice)
        BigDecimal totalNecessarioEth = valorEth.add(Convert.fromWei(new BigDecimal(gasLimitEstimado.multiply(gasPrice)), Convert.Unit.ETHER));

        // 6️⃣ Verifica se há saldo suficiente
        if (saldoEth.compareTo(totalNecessarioEth) < 0) {
            throw new RuntimeException("Saldo insuficiente: saldo disponível " + saldoEth
                    + " ETH, valor a transferir " + valorEth + " ETH + gas estimado "
                    + Convert.fromWei(new BigDecimal(gasLimitEstimado.multiply(gasPrice)), Convert.Unit.ETHER) + " ETH");
        }

        // 7️⃣ Executa transferência
        return Transfer.sendFunds(
                web3j,
                fromCredentials,
                toAddress,
                valorEth,
                Convert.Unit.ETHER
        ).send().getTransactionHash();
    }
}
