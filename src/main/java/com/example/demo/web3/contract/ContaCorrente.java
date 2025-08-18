package com.example.demo.web3.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    public static final String BINARY = "6080604052348015600e575f5ffd5b506104b78061001c5f395ff3fe608060405260043610610033575f3560e01c80633d922f90146100375780637371b0d614610041578063d6f033fd14610069575b5f5ffd5b61003f610093565b005b34801561004c575f5ffd5b50610067600480360381019061006291906102bb565b610129565b005b348015610074575f5ffd5b5061007d610241565b60405161008a91906102f5565b60405180910390f35b5f34116100d5576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016100cc90610368565b60405180910390fd5b345f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f82825461012091906103b3565b92505081905550565b805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205410156101a8576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161019f90610430565b60405180910390fd5b805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8282546101f3919061044e565b925050819055503373ffffffffffffffffffffffffffffffffffffffff166108fc8290811502906040515f60405180830381858888f1935050505015801561023d573d5f5f3e3d5ffd5b5050565b5f5f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2054905090565b5f5ffd5b5f819050919050565b61029a81610288565b81146102a4575f5ffd5b50565b5f813590506102b581610291565b92915050565b5f602082840312156102d0576102cf610284565b5b5f6102dd848285016102a7565b91505092915050565b6102ef81610288565b82525050565b5f6020820190506103085f8301846102e6565b92915050565b5f82825260208201905092915050565b7f56616c6f72206465766520736572206d61696f7220717565207a65726f0000005f82015250565b5f610352601d8361030e565b915061035d8261031e565b602082019050919050565b5f6020820190508181035f83015261037f81610346565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f6103bd82610288565b91506103c883610288565b92508282019050808211156103e0576103df610386565b5b92915050565b7f53616c646f20696e737566696369656e746500000000000000000000000000005f82015250565b5f61041a60128361030e565b9150610425826103e6565b602082019050919050565b5f6020820190508181035f8301526104478161040e565b9050919050565b5f61045882610288565b915061046383610288565b925082820390508181111561047b5761047a610386565b5b9291505056fea2646970667358221220db4dd5f5d66956926da29c6dba35a53661c17b3461800534db06fdd194a0b79364736f6c634300081e0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEPOSITAR = "depositar";

    public static final String FUNC_SACAR = "sacar";

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
