package com.example.demo.web3.controller;

import com.example.demo.web3.dto.TransacaoRequest; // vamos usar para depositar/sacar
import com.example.demo.web3.service.EthereumService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
        return "Depósito enviado! Hash: " +
                ethereumService.depositar(request.getContratoAddress(), request.getValorEth());
    }

    // Consulta saldo no contrato
    @GetMapping("/saldo/{contratoAddress}")
    public BigDecimal consultarSaldo(@PathVariable String contratoAddress) throws Exception {
        return ethereumService.consultarSaldo(contratoAddress);
    }

    // Saca valor do contrato
    @PostMapping("/sacar")
    public String sacar(@RequestBody TransacaoRequest request) throws Exception {
        return "Saque realizado! Hash: " +
                ethereumService.sacar(request.getContratoAddress(), request.getValorEth());
    }
}
