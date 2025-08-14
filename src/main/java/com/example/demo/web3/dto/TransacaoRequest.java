package com.example.demo.web3.dto;

import java.math.BigDecimal;

public class TransacaoRequest {
    private String enderecoDestino;
    private BigDecimal valorEth;

    // Getters e setters
    public String getEnderecoDestino() {
        return enderecoDestino;
    }
    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    public BigDecimal getValorEth() {
        return valorEth;
    }
    public void setValorEth(BigDecimal valorEth) {
        this.valorEth = valorEth;
    }
}