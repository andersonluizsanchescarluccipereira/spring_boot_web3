package com.example.demo.web3.controller;

import com.example.demo.web3.dto.TransacaoRequest;
import com.example.demo.web3.dto.TransferenciaRequest;
import com.example.demo.web3.service.EthereumService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class EthereumController {
    private final EthereumService ethereumService;

    public EthereumController(EthereumService ethereumService) {
        this.ethereumService = ethereumService;
    }
    @GetMapping("/ethereum/version")
    public String getEthereumVersion() throws Exception {
        return ethereumService.getClientVersion();
    }
    @PostMapping("/ethereum/send")
    public String enviar(@RequestBody TransacaoRequest request) throws Exception {
        return "Transação enviada! Hash: " +
                ethereumService.sendTransaction(request.getEnderecoDestino(), request.getValorEth());
    }

    // Endpoint para buscar saldo de um endereço
    @GetMapping("/ethereum/valueeth/{address}")
    public BigDecimal saldo(@PathVariable String address) throws Exception {
        return ethereumService.buscarSaldo(address);
    }
    @PostMapping("/ethereum/transfer")
    public String transferir(@RequestBody TransferenciaRequest request) throws Exception {
        return "Transação enviada! Hash: " +
                ethereumService.transferir(
                        request.getEnderecoRemetente(),
                        request.getEnderecoDestino(),
                        request.getValorEth()
                );
    }
}
