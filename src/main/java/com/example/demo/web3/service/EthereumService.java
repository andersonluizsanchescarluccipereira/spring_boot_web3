package com.example.demo.web3.service;

import java.math.BigInteger;
import java.util.List;
import com.example.demo.web3.contract.ContaCorrente;
import com.example.demo.web3.contract.ContaCorrente.ContaCriadaEventResponse;
import com.example.demo.web3.contract.ContaCorrente.DepositoEventResponse;
import com.example.demo.web3.contract.ContaCorrente.PixRealizadoEventResponse;
import com.example.demo.web3.contract.ContaCorrente.SaqueEventResponse;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public interface EthereumService {

    String getClientVersion() throws Exception;

    ContaCorrente loadContract(String contractAddress) throws Exception;

    TransactionReceipt criarConta(BigInteger numeroContrato) throws Exception;

    TransactionReceipt depositar(BigInteger numeroContrato, BigInteger valorWei) throws Exception;

    TransactionReceipt pix(BigInteger deContrato, BigInteger paraContrato, BigInteger valor) throws Exception;

    TransactionReceipt sacar(BigInteger numeroContrato, BigInteger valor) throws Exception;

    BigInteger consultarSaldo(BigInteger numeroContrato) throws Exception;

    List<ContaCriadaEventResponse> listarContasCriadas(TransactionReceipt receipt);

    List<DepositoEventResponse> listarDepositos(TransactionReceipt receipt);

    List<PixRealizadoEventResponse> listarPix(TransactionReceipt receipt);

    List<SaqueEventResponse> listarSaques(TransactionReceipt receipt);
}
