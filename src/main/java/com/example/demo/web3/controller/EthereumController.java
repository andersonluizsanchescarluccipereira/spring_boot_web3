package com.example.demo.web3.controller;

import com.example.demo.web3.service.EthereumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
