package com.example.demo.web3.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
    public static final String BINARY = "6080604052348015600e575f5ffd5b506111318061001c5f395ff3fe608060405260043610610054575f3560e01c80636f07fec314610058578063d5ca622814610096578063d8b5f3f9146100b2578063e5aabc89146100ee578063fd4b9f0114610116578063fdeca8ca1461013e575b5f5ffd5b348015610063575f5ffd5b5061007e60048036038101906100799190610a8a565b610166565b60405161008d93929190610b1d565b60405180910390f35b6100b060048036038101906100ab9190610a8a565b61027a565b005b3480156100bd575f5ffd5b506100d860048036038101906100d39190610a8a565b610382565b6040516100e59190610b52565b60405180910390f35b3480156100f9575f5ffd5b50610114600480360381019061010f9190610b6b565b6103fd565b005b348015610121575f5ffd5b5061013c60048036038101906101379190610ba9565b6105fd565b005b348015610149575f5ffd5b50610164600480360381019061015f9190610a8a565b610842565b005b5f5f5f5f5f8581526020019081526020015f206002015f9054906101000a900460ff166101c8576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016101bf90610c53565b60405180910390fd5b5f5f5f8681526020019081526020015f206040518060600160405290815f82015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015f9054906101000a900460ff1615151515815250509050805f015181602001518260400151935093509350509193909250565b5f5f8281526020019081526020015f206002015f9054906101000a900460ff166102d9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102d090610c53565b60405180910390fd5b5f341161031b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161031290610cbb565b60405180910390fd5b345f5f8381526020019081526020015f206001015f82825461033d9190610d06565b925050819055507f0fdfd499eca43e68baa74b01c4653da4ffc2639f7363d4749429fd250c32448b81333460405161037793929190610d39565b60405180910390a150565b5f5f5f8381526020019081526020015f206002015f9054906101000a900460ff166103e2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103d990610c53565b60405180910390fd5b5f5f8381526020019081526020015f20600101549050919050565b5f5f8381526020019081526020015f206002015f9054906101000a900460ff1661045c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161045390610c53565b60405180910390fd5b3373ffffffffffffffffffffffffffffffffffffffff165f5f8481526020019081526020015f205f015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16146104fb576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016104f290610db8565b60405180910390fd5b805f5f8481526020019081526020015f20600101541015610551576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161054890610e20565b60405180910390fd5b805f5f8481526020019081526020015f206001015f8282546105739190610e3e565b925050819055503373ffffffffffffffffffffffffffffffffffffffff166108fc8290811502906040515f60405180830381858888f193505050501580156105bd573d5f5f3e3d5ffd5b507f2941a8c0681fdee4d5d91c1b4fcb0355112d5bdd74e08b5e6e9778d34c8858e18233836040516105f193929190610d39565b60405180910390a15050565b5f5f8481526020019081526020015f206002015f9054906101000a900460ff1661065c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161065390610ebb565b60405180910390fd5b5f5f8381526020019081526020015f206002015f9054906101000a900460ff166106bb576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016106b290610f23565b60405180910390fd5b3373ffffffffffffffffffffffffffffffffffffffff165f5f8581526020019081526020015f205f015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161461075a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161075190610fb1565b60405180910390fd5b805f5f8581526020019081526020015f206001015410156107b0576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016107a790610e20565b60405180910390fd5b805f5f8581526020019081526020015f206001015f8282546107d29190610e3e565b92505081905550805f5f8481526020019081526020015f206001015f8282546107fb9190610d06565b925050819055507fc3bd1ef839b909db3d163868d794946738d162ed1742c67738b0984e4634bcc383838360405161083593929190610fcf565b60405180910390a1505050565b5f5f8281526020019081526020015f206002015f9054906101000a900460ff16156108a2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016108999061104e565b60405180910390fd5b5f60015f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205414610921576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610918906110b6565b60405180910390fd5b60405180606001604052803373ffffffffffffffffffffffffffffffffffffffff1681526020015f8152602001600115158152505f5f8381526020019081526020015f205f820151815f015f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101556040820151816002015f6101000a81548160ff0219169083151502179055509050508060015f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20819055507f44a3980b8a75a55759c661f98f41097020606ee8e00a0896d2b51542e6cdda848133604051610a489291906110d4565b60405180910390a150565b5f5ffd5b5f819050919050565b610a6981610a57565b8114610a73575f5ffd5b50565b5f81359050610a8481610a60565b92915050565b5f60208284031215610a9f57610a9e610a53565b5b5f610aac84828501610a76565b91505092915050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f610ade82610ab5565b9050919050565b610aee81610ad4565b82525050565b610afd81610a57565b82525050565b5f8115159050919050565b610b1781610b03565b82525050565b5f606082019050610b305f830186610ae5565b610b3d6020830185610af4565b610b4a6040830184610b0e565b949350505050565b5f602082019050610b655f830184610af4565b92915050565b5f5f60408385031215610b8157610b80610a53565b5b5f610b8e85828601610a76565b9250506020610b9f85828601610a76565b9150509250929050565b5f5f5f60608486031215610bc057610bbf610a53565b5b5f610bcd86828701610a76565b9350506020610bde86828701610a76565b9250506040610bef86828701610a76565b9150509250925092565b5f82825260208201905092915050565b7f436f6e746120696e6578697374656e74650000000000000000000000000000005f82015250565b5f610c3d601183610bf9565b9150610c4882610c09565b602082019050919050565b5f6020820190508181035f830152610c6a81610c31565b9050919050565b7f56616c6f72206465766520736572206d61696f7220717565207a65726f0000005f82015250565b5f610ca5601d83610bf9565b9150610cb082610c71565b602082019050919050565b5f6020820190508181035f830152610cd281610c99565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f610d1082610a57565b9150610d1b83610a57565b9250828201905080821115610d3357610d32610cd9565b5b92915050565b5f606082019050610d4c5f830186610af4565b610d596020830185610ae5565b610d666040830184610af4565b949350505050565b7f536f6d656e7465206f20746974756c617220706f6465207361636172000000005f82015250565b5f610da2601c83610bf9565b9150610dad82610d6e565b602082019050919050565b5f6020820190508181035f830152610dcf81610d96565b9050919050565b7f53616c646f20696e737566696369656e746500000000000000000000000000005f82015250565b5f610e0a601283610bf9565b9150610e1582610dd6565b602082019050919050565b5f6020820190508181035f830152610e3781610dfe565b9050919050565b5f610e4882610a57565b9150610e5383610a57565b9250828203905081811115610e6b57610e6a610cd9565b5b92915050565b7f436f6e74612072656d6574656e746520696e6578697374656e746500000000005f82015250565b5f610ea5601b83610bf9565b9150610eb082610e71565b602082019050919050565b5f6020820190508181035f830152610ed281610e99565b9050919050565b7f436f6e74612064657374696e61746172696120696e6578697374656e746500005f82015250565b5f610f0d601e83610bf9565b9150610f1882610ed9565b602082019050919050565b5f6020820190508181035f830152610f3a81610f01565b9050919050565b7f536f6d656e7465206f20746974756c617220706f6465207472616e73666572695f8201527f7200000000000000000000000000000000000000000000000000000000000000602082015250565b5f610f9b602183610bf9565b9150610fa682610f41565b604082019050919050565b5f6020820190508181035f830152610fc881610f8f565b9050919050565b5f606082019050610fe25f830186610af4565b610fef6020830185610af4565b610ffc6040830184610af4565b949350505050565b7f4e756d65726f20646520636f6e747261746f206a6120657869737465000000005f82015250565b5f611038601c83610bf9565b915061104382611004565b602082019050919050565b5f6020820190508181035f8301526110658161102c565b9050919050565b7f456e64657265636f206a6120706f7373756920636f6e746100000000000000005f82015250565b5f6110a0601883610bf9565b91506110ab8261106c565b602082019050919050565b5f6020820190508181035f8301526110cd81611094565b9050919050565b5f6040820190506110e75f830185610af4565b6110f46020830184610ae5565b939250505056fea2646970667358221220c1fb36f5a5c40b98f60109628d4d34e670574d626841f97c0145c8d2b0049c1e64736f6c634300081e0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_CRIARCONTA = "criarConta";

    public static final String FUNC_DEPOSITAR = "depositar";

    public static final String FUNC_PIX = "pix";

    public static final String FUNC_SACAR = "sacar";

    public static final String FUNC_CONSULTARSALDO = "consultarSaldo";

    public static final String FUNC_VERCONTA = "verConta";

    public static final Event CONTACRIADA_EVENT = new Event("ContaCriada", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event DEPOSITO_EVENT = new Event("Deposito", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event PIXREALIZADO_EVENT = new Event("PixRealizado", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SAQUE_EVENT = new Event("Saque", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

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

    public static List<ContaCriadaEventResponse> getContaCriadaEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CONTACRIADA_EVENT, transactionReceipt);
        ArrayList<ContaCriadaEventResponse> responses = new ArrayList<ContaCriadaEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ContaCriadaEventResponse typedResponse = new ContaCriadaEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.numeroContrato = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.titular = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ContaCriadaEventResponse getContaCriadaEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(CONTACRIADA_EVENT, log);
        ContaCriadaEventResponse typedResponse = new ContaCriadaEventResponse();
        typedResponse.log = log;
        typedResponse.numeroContrato = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.titular = (String) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<ContaCriadaEventResponse> contaCriadaEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getContaCriadaEventFromLog(log));
    }

    public Flowable<ContaCriadaEventResponse> contaCriadaEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTACRIADA_EVENT));
        return contaCriadaEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> criarConta(BigInteger numeroContrato) {
        final Function function = new Function(
                FUNC_CRIARCONTA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(numeroContrato)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> depositar(BigInteger numeroContrato,
            BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DEPOSITAR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(numeroContrato)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public static List<DepositoEventResponse> getDepositoEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DEPOSITO_EVENT, transactionReceipt);
        ArrayList<DepositoEventResponse> responses = new ArrayList<DepositoEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DepositoEventResponse typedResponse = new DepositoEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.numeroContrato = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.remetente = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.valor = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static DepositoEventResponse getDepositoEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(DEPOSITO_EVENT, log);
        DepositoEventResponse typedResponse = new DepositoEventResponse();
        typedResponse.log = log;
        typedResponse.numeroContrato = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.remetente = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.valor = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<DepositoEventResponse> depositoEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getDepositoEventFromLog(log));
    }

    public Flowable<DepositoEventResponse> depositoEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSITO_EVENT));
        return depositoEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> pix(BigInteger deContrato,
            BigInteger paraContrato, BigInteger valor) {
        final Function function = new Function(
                FUNC_PIX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(deContrato), 
                new org.web3j.abi.datatypes.generated.Uint256(paraContrato), 
                new org.web3j.abi.datatypes.generated.Uint256(valor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<PixRealizadoEventResponse> getPixRealizadoEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PIXREALIZADO_EVENT, transactionReceipt);
        ArrayList<PixRealizadoEventResponse> responses = new ArrayList<PixRealizadoEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PixRealizadoEventResponse typedResponse = new PixRealizadoEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.deContrato = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.paraContrato = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.valor = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static PixRealizadoEventResponse getPixRealizadoEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PIXREALIZADO_EVENT, log);
        PixRealizadoEventResponse typedResponse = new PixRealizadoEventResponse();
        typedResponse.log = log;
        typedResponse.deContrato = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.paraContrato = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.valor = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<PixRealizadoEventResponse> pixRealizadoEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getPixRealizadoEventFromLog(log));
    }

    public Flowable<PixRealizadoEventResponse> pixRealizadoEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PIXREALIZADO_EVENT));
        return pixRealizadoEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> sacar(BigInteger numeroContrato,
            BigInteger valor) {
        final Function function = new Function(
                FUNC_SACAR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(numeroContrato), 
                new org.web3j.abi.datatypes.generated.Uint256(valor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<SaqueEventResponse> getSaqueEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SAQUE_EVENT, transactionReceipt);
        ArrayList<SaqueEventResponse> responses = new ArrayList<SaqueEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SaqueEventResponse typedResponse = new SaqueEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.numeroContrato = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.titular = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.valor = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static SaqueEventResponse getSaqueEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SAQUE_EVENT, log);
        SaqueEventResponse typedResponse = new SaqueEventResponse();
        typedResponse.log = log;
        typedResponse.numeroContrato = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.titular = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.valor = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<SaqueEventResponse> saqueEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSaqueEventFromLog(log));
    }

    public Flowable<SaqueEventResponse> saqueEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SAQUE_EVENT));
        return saqueEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> consultarSaldo(BigInteger numeroContrato) {
        final Function function = new Function(FUNC_CONSULTARSALDO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(numeroContrato)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple3<String, BigInteger, Boolean>> verConta(
            BigInteger numeroContrato) {
        final Function function = new Function(FUNC_VERCONTA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(numeroContrato)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple3<String, BigInteger, Boolean>>(function,
                new Callable<Tuple3<String, BigInteger, Boolean>>() {
                    @Override
                    public Tuple3<String, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, BigInteger, Boolean>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (Boolean) results.get(2).getValue());
                    }
                });
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

    public static class ContaCriadaEventResponse extends BaseEventResponse {
        public BigInteger numeroContrato;

        public String titular;
    }

    public static class DepositoEventResponse extends BaseEventResponse {
        public BigInteger numeroContrato;

        public String remetente;

        public BigInteger valor;
    }

    public static class PixRealizadoEventResponse extends BaseEventResponse {
        public BigInteger deContrato;

        public BigInteger paraContrato;

        public BigInteger valor;
    }

    public static class SaqueEventResponse extends BaseEventResponse {
        public BigInteger numeroContrato;

        public String titular;

        public BigInteger valor;
    }
}
