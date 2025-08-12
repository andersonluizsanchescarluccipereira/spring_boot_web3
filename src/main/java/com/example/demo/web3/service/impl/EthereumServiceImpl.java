package com.example.demo.web3.service.impl;

import com.example.demo.web3.service.EthereumService;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

@Service
public class EthereumServiceImpl implements EthereumService {
    private final Web3j web3j;
    public EthereumServiceImpl(Web3j web3j) {
        this.web3j = web3j;
    }
    public String getClientVersion() throws IOException {
        Web3ClientVersion clientVersion = web3j.web3ClientVersion().send();
        return clientVersion.getWeb3ClientVersion();
    }
}
