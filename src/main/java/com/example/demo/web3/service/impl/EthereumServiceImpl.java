package com.example.demo.web3.service.impl;

import com.example.demo.web3.contract.ContaCorrente; // wrapper gerado do contrato
import com.example.demo.web3.service.EthereumService;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
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
        BigInteger valorWei = Convert.toWei(valorEth, Convert.Unit.ETHER).toBigInteger();

        // Passa o valor em Wei na transação
        return contrato.depositar(valorWei).send().getTransactionHash();
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
}
