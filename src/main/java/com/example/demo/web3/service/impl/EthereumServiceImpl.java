package com.example.demo.web3.service.impl;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.web3.contract.ContaCorrente;
import com.example.demo.web3.contract.ContaCorrente.ContaCriadaEventResponse;
import com.example.demo.web3.contract.ContaCorrente.DepositoEventResponse;
import com.example.demo.web3.contract.ContaCorrente.PixRealizadoEventResponse;
import com.example.demo.web3.contract.ContaCorrente.SaqueEventResponse;
import com.example.demo.web3.service.EthereumService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

@Service
public class EthereumServiceImpl implements EthereumService {

    private final Web3j web3j;
    private ContaCorrente contaCorrente;
    private final String privateKey;

    public EthereumServiceImpl(Web3j web3j,
                               @Value("${ethereum.private.key}") String privateKey) {
        this.web3j = web3j;
        this.privateKey = privateKey;
    }

    @Override
    public String getClientVersion() throws Exception {
        return web3j.web3ClientVersion().send().getWeb3ClientVersion();
    }

    @Override
    public ContaCorrente loadContract(String contractAddress) {
        // Evita recarregar se já tiver o contrato
        if (this.contaCorrente != null && this.contaCorrente.getContractAddress().equals(contractAddress)) {
            return this.contaCorrente;
        }

        Credentials credentials = Credentials.create(this.privateKey);
        ContractGasProvider gasProvider = new DefaultGasProvider();

        this.contaCorrente = ContaCorrente.load(contractAddress, web3j, credentials, gasProvider);
        return this.contaCorrente;
    }

    @Override
    public TransactionReceipt criarConta(BigInteger numeroContrato) throws Exception {
        return contaCorrente.criarConta(numeroContrato).send();
    }

    @Override
    public TransactionReceipt depositar(BigInteger numeroContrato, BigInteger valorWei) throws Exception {
        return contaCorrente.depositar(numeroContrato, valorWei).send();
    }

    @Override
    public TransactionReceipt pix(BigInteger deContrato, BigInteger paraContrato, BigInteger valor) throws Exception {
        return contaCorrente.pix(deContrato, paraContrato, valor).send();
    }

    @Override
    public TransactionReceipt sacar(BigInteger numeroContrato, BigInteger valor) throws Exception {
        return contaCorrente.sacar(numeroContrato, valor).send();
    }

    @Override
    public BigInteger consultarSaldo(BigInteger numeroContrato) throws Exception {
        return contaCorrente.consultarSaldo(numeroContrato).send();
    }

    @Override
    public List<ContaCriadaEventResponse> listarContasCriadas(TransactionReceipt receipt) {
        return ContaCorrente.getContaCriadaEvents(receipt);
    }

    @Override
    public List<DepositoEventResponse> listarDepositos(TransactionReceipt receipt) {
        return ContaCorrente.getDepositoEvents(receipt);
    }

    @Override
    public List<PixRealizadoEventResponse> listarPix(TransactionReceipt receipt) {
        return ContaCorrente.getPixRealizadoEvents(receipt);
    }

    @Override
    public List<SaqueEventResponse> listarSaques(TransactionReceipt receipt) {
        return ContaCorrente.getSaqueEvents(receipt);
    }
}
