package com.example.demo.web3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class Web3jConfig {

    @Bean
    public Web3j web3j() {
        // URL do seu nó Ethereum (Ganache, Infura, Alchemy, etc.)
        return Web3j.build(new HttpService("http://127.0.0.1:8545"));
    }
}
