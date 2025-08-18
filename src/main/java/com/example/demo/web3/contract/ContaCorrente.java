package com.example.demo.web3.contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.7.0.
 */
@SuppressWarnings("rawtypes")
public class ContaCorrente extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b5061077f8061001c5f395ff3fe60806040526004361061003e575f3560e01c80633d922f901461004257806340847d2d1461004c5780637371b0d614610074578063d6f033fd1461009c575b5f5ffd5b61004a6100c6565b005b348015610057575f5ffd5b50610072600480360381019061006d91906104dd565b61015c565b005b34801561007f575f5ffd5b5061009a6004803603810190610095919061051b565b6102f1565b005b3480156100a7575f5ffd5b506100b0610409565b6040516100bd9190610555565b60405180910390f35b5f3411610108576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016100ff906105c8565b60405180910390fd5b345f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8282546101539190610613565b92505081905550565b805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205410156101db576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016101d290610690565b60405180910390fd5b5f73ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1603610249576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610240906106f8565b60405180910390fd5b805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8282546102949190610716565b92505081905550805f5f8473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8282546102e69190610613565b925050819055505050565b805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20541015610370576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161036790610690565b60405180910390fd5b805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8282546103bb9190610716565b925050819055503373ffffffffffffffffffffffffffffffffffffffff166108fc8290811502906040515f60405180830381858888f19350505050158015610405573d5f5f3e3d5ffd5b5050565b5f5f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2054905090565b5f5ffd5b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f61047982610450565b9050919050565b6104898161046f565b8114610493575f5ffd5b50565b5f813590506104a481610480565b92915050565b5f819050919050565b6104bc816104aa565b81146104c6575f5ffd5b50565b5f813590506104d7816104b3565b92915050565b5f5f604083850312156104f3576104f261044c565b5b5f61050085828601610496565b9250506020610511858286016104c9565b9150509250929050565b5f602082840312156105305761052f61044c565b5b5f61053d848285016104c9565b91505092915050565b61054f816104aa565b82525050565b5f6020820190506105685f830184610546565b92915050565b5f82825260208201905092915050565b7f56616c6f72206465766520736572206d61696f7220717565207a65726f0000005f82015250565b5f6105b2601d8361056e565b91506105bd8261057e565b602082019050919050565b5f6020820190508181035f8301526105df816105a6565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f61061d826104aa565b9150610628836104aa565b92508282019050808211156106405761063f6105e6565b5b92915050565b7f53616c646f20696e737566696369656e746500000000000000000000000000005f82015250565b5f61067a60128361056e565b915061068582610646565b602082019050919050565b5f6020820190508181035f8301526106a78161066e565b9050919050565b7f44657374696e61746172696f20696e76616c69646f00000000000000000000005f82015250565b5f6106e260158361056e565b91506106ed826106ae565b602082019050919050565b5f6020820190508181035f83015261070f816106d6565b9050919050565b5f610720826104aa565b915061072b836104aa565b9250828203905081811115610743576107426105e6565b5b9291505056fea26469706673582212201d69cfea55ac030b979e89f94d26551ca0dcd016986ebbd5a168e3a9799b2e6a64736f6c634300081e0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEPOSITAR = "depositar";

    public static final String FUNC_SACAR = "sacar";

    public static final String FUNC_TRANSFERIR = "transferir";

    public static final String FUNC_CONSULTARSALDO = "consultarSaldo";

    @Deprecated
    protected ContaCorrente(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ContaCorrente(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ContaCorrente(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ContaCorrente(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> depositar(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DEPOSITAR, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> sacar(BigInteger valor) {
        final Function function = new Function(
                FUNC_SACAR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(valor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferir(String destinatario,
                                                             BigInteger valor) {
        final Function function = new Function(
                FUNC_TRANSFERIR,
                Arrays.asList(new org.web3j.abi.datatypes.Address(160, destinatario),
                        new org.web3j.abi.datatypes.generated.Uint256(valor)),
                Collections.emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> consultarSaldo() {
        final Function function = new Function(FUNC_CONSULTARSALDO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static ContaCorrente load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new ContaCorrente(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ContaCorrente load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContaCorrente(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ContaCorrente load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new ContaCorrente(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ContaCorrente load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ContaCorrente(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ContaCorrente> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContaCorrente.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<ContaCorrente> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContaCorrente.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<ContaCorrente> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContaCorrente.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<ContaCorrente> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContaCorrente.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
