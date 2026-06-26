package com.banking.transaction.repositories.transactionFileManager;

import java.io.File;
import java.util.List;

import com.banking.transaction.entities.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class TransactionsFileIOImpl implements TransactionsFileIO{

    ObjectMapper mapper=new ObjectMapper();
    File transactionsFile=new File("Transactions.json");
    
    public TransactionsFileIOImpl(){
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serializeTransaction(List<Transaction> transactions){
        try{
            mapper.writeValue(transactionsFile,transactions);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> deserializeTransaction(){
        try{
            List<Transaction> transactions = mapper.readValue(transactionsFile, new TypeReference<List<Transaction>>() {});
            return transactions;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
