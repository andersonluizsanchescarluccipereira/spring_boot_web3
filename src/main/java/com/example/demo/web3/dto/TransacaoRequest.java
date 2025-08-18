package com.example.demo.web3.dto;

import java.math.BigDecimal;

public class TransacaoRequest {

    // Usado para interações com contrato
    private String contratoAddress;

    // Usado para transferências diretas
    private String fromPrivateKey;
    private String toAddress;

    // Valor em ETH (comum para todos)
    private BigDecimal valorEth;

    public TransacaoRequest() {}

    // Getters e Setters
    public String getContratoAddress() {
        return contratoAddress;
    }

    public void setContratoAddress(String contratoAddress) {
        this.contratoAddress = contratoAddress;
    }

    public String getFromPrivateKey() {
        return fromPrivateKey;
    }

    public void setFromPrivateKey(String fromPrivateKey) {
        this.fromPrivateKey = fromPrivateKey;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public BigDecimal getValorEth() {
        return valorEth;
    }

    public void setValorEth(BigDecimal valorEth) {
        this.valorEth = valorEth;
    }
}
