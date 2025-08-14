package com.example.demo.web3.dto;

import java.math.BigDecimal;

public class TransferenciaRequest {
    private String enderecoRemetente; // usado apenas para validação
    private String enderecoDestino;
    private BigDecimal valorEth;

    // Getters e setters
    public String getEnderecoRemetente() { return enderecoRemetente; }
    public void setEnderecoRemetente(String enderecoRemetente) { this.enderecoRemetente = enderecoRemetente; }

    public String getEnderecoDestino() { return enderecoDestino; }
    public void setEnderecoDestino(String enderecoDestino) { this.enderecoDestino = enderecoDestino; }

    public BigDecimal getValorEth() { return valorEth; }
    public void setValorEth(BigDecimal valorEth) { this.valorEth = valorEth; }
}
