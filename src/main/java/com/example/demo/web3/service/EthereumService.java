package com.example.demo.web3.service;

import java.io.IOException;
import java.math.BigDecimal;

public interface EthereumService {

    // Retorna a versão do cliente Web3
    String getClientVersion() throws IOException;

    // Deposita valor na conta do contrato
    String depositar(String contratoAddress, BigDecimal valorEth) throws Exception;

    // Consulta o saldo da conta no contrato
    BigDecimal consultarSaldo(String contratoAddress) throws Exception;

    // Saca valor da conta no contrato
    String sacar(String contratoAddress, BigDecimal valorEth) throws Exception;

    String transferir(String fromPrivateKey, String toAddress, BigDecimal valorEth) throws Exception;
}
