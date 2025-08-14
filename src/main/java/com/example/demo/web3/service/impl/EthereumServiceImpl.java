package com.example.demo.web3.service.impl;

import com.example.demo.web3.service.EthereumService;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class EthereumServiceImpl implements EthereumService {
    private final Web3j web3j;
    private final String chavePrivada;
    public EthereumServiceImpl(Web3j web3j) {
        this.web3j = web3j;
        // Lê a chave privada da variável de ambiente
        this.chavePrivada = System.getenv("PRIVATE_KEY");
        if (this.chavePrivada == null || this.chavePrivada.isEmpty()) {
            throw new RuntimeException("Variável de ambiente CHAVE_PRIVADA não definida!");
        }
    }
    public String getClientVersion() throws IOException {
        Web3ClientVersion clientVersion = web3j.web3ClientVersion().send();
        return clientVersion.getWeb3ClientVersion();
    }

    @Override
    public String sendTransaction(String enderecoDestino, BigDecimal valorEth) throws Exception {
        Credentials credentials = Credentials.create(chavePrivada);

        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
                credentials.getAddress(), org.web3j.protocol.core.DefaultBlockParameterName.LATEST
        ).send();

        BigInteger nonce = ethGetTransactionCount.getTransactionCount();
        BigInteger valorWei = Convert.toWei(valorEth, Convert.Unit.ETHER).toBigInteger();
        BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L);
        BigInteger gasLimit = BigInteger.valueOf(21_000);

        RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
                nonce, gasPrice, gasLimit, enderecoDestino, valorWei
        );

        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        String hexValue = Numeric.toHexString(signedMessage);

        EthSendTransaction transactionResponse = web3j.ethSendRawTransaction(hexValue).send();
        return transactionResponse.getTransactionHash();
    }
    public BigDecimal buscarSaldo(String endereco) throws Exception {
        BigInteger saldoWei = web3j.ethGetBalance(endereco, DefaultBlockParameterName.LATEST)
                .send()
                .getBalance();
        // Converter de Wei para Ether
        return Convert.fromWei(new BigDecimal(saldoWei), Convert.Unit.ETHER);
    }
    private void validarChave(String endereco) {
        Credentials credentials = Credentials.create(chavePrivada);
        if (!credentials.getAddress().equalsIgnoreCase(endereco)) {
            throw new RuntimeException("Chave privada não corresponde ao endereço remetente");
        }
    }

    // Transferência segura
    public String transferir(String enderecoRemetente, String enderecoDestino, BigDecimal valorEth) throws Exception {
        // 1️⃣ Validar chave
        validarChave(enderecoRemetente);

        // 2️⃣ Verificar saldo
        BigDecimal saldo = buscarSaldo(enderecoRemetente);
        if (saldo.compareTo(valorEth) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        // 3️⃣ Criar e enviar transação
        Credentials credentials = Credentials.create(chavePrivada);
        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
                enderecoRemetente, DefaultBlockParameterName.LATEST
        ).send();

        BigInteger nonce = ethGetTransactionCount.getTransactionCount();
        BigInteger valorWei = Convert.toWei(valorEth, Convert.Unit.ETHER).toBigInteger();
        BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L);
        BigInteger gasLimit = BigInteger.valueOf(21_000);

        RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
                nonce, gasPrice, gasLimit, enderecoDestino, valorWei
        );

        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        String hexValue = Numeric.toHexString(signedMessage);

        EthSendTransaction transactionResponse = web3j.ethSendRawTransaction(hexValue).send();
        return transactionResponse.getTransactionHash();
    }
}
