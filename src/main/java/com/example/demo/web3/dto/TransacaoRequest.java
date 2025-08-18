package com.example.demo.web3.dto;

import java.math.BigDecimal;

public class TransacaoRequest {

    // Endereço do contrato ContaCorrente no Ganache
    private String contratoAddress;

    // Valor em ETH a depositar ou sacar
    private BigDecimal valorEth;

    public TransacaoRequest() {
    }

    public TransacaoRequest(String contratoAddress, BigDecimal valorEth) {
        this.contratoAddress = contratoAddress;
        this.valorEth = valorEth;
    }

    public String getContratoAddress() {
        return contratoAddress;
    }

    public void setContratoAddress(String contratoAddress) {
        this.contratoAddress = contratoAddress;
    }

    public BigDecimal getValorEth() {
        return valorEth;
    }

    public void setValorEth(BigDecimal valorEth) {
        this.valorEth = valorEth;
    }
}
