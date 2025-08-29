package com.example.demo.web3.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * DTO para operações com o contrato ContaCorrente e transferências diretas.
 */
public record TransacaoRequest(
        // ---------------------------
        // Para interações com contrato
        // ---------------------------
        String contratoAddress,
        BigInteger numeroContrato,
        BigInteger deContrato,
        BigInteger paraContrato,

        // ---------------------------
        // Para transferências diretas
        // ---------------------------
        String fromPrivateKey,
        String toAddress,

        // ---------------------------
        // Valor em ETH ou unidades do contrato
        // ---------------------------
        BigDecimal valorEth
) {}
