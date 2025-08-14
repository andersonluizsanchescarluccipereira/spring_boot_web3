package com.example.demo.web3.service;

import java.io.IOException;
import java.math.BigDecimal;

public interface EthereumService {
    String getClientVersion() throws IOException;
    String sendTransaction(String enderecoDestino, BigDecimal valorEth) throws Exception;
    BigDecimal buscarSaldo(String endereco) throws Exception;
    String transferir(String enderecoRemetente, String enderecoDestino, BigDecimal valorEth) throws Exception;
}
