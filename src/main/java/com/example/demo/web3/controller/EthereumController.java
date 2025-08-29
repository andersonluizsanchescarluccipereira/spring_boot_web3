package com.example.demo.web3.controller;

import com.example.demo.web3.dto.TransacaoRequest;
import com.example.demo.web3.service.EthereumService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
@RequestMapping("/ethereum")
public class EthereumController {

    private final EthereumService ethereumService;

    public EthereumController(EthereumService ethereumService) {
        this.ethereumService = ethereumService;
    }

    // Retorna a versão do cliente Web3
    @GetMapping("/version")
    public String getEthereumVersion() throws Exception {
        return ethereumService.getClientVersion();
    }

    // Deposita valor no contrato
    @PostMapping("/depositar")
    public String depositar(@RequestBody TransacaoRequest request) throws Exception {
        // Carrega contrato
        ethereumService.loadContract(request.contratoAddress());
        // Converte valor ETH -> wei
        BigInteger valorWei = ethToWei(request.valorEth());
        // Executa depósito
        return "Depósito enviado! Hash: " +
                ethereumService.depositar(request.numeroContrato(), valorWei).getTransactionHash();
    }

    // Consulta saldo no contrato
    @GetMapping("/saldo/{contratoAddress}/{numeroContrato}")
    public BigDecimal consultarSaldo(@PathVariable String contratoAddress,
                                     @PathVariable BigInteger numeroContrato) throws Exception {
        ethereumService.loadContract(contratoAddress);
        BigInteger saldoWei = ethereumService.consultarSaldo(numeroContrato);
        return weiToEth(saldoWei);
    }

    // Saca valor do contrato
    @PostMapping("/sacar")
    public String sacar(@RequestBody TransacaoRequest request) throws Exception {
        ethereumService.loadContract(request.contratoAddress());
        BigInteger valorWei = ethToWei(request.valorEth());
        return "Saque realizado! Hash: " +
                ethereumService.sacar(request.numeroContrato(), valorWei).getTransactionHash();
    }


    // =======================
    // Utils
    // =======================
    private BigInteger ethToWei(BigDecimal eth) {
        return eth.multiply(BigDecimal.valueOf(1_000_000_000_000_000_000L)).toBigInteger();
    }

    private BigDecimal weiToEth(BigInteger wei) {
        return new BigDecimal(wei).divide(BigDecimal.valueOf(1_000_000_000_000_000_000L));
    }
}
