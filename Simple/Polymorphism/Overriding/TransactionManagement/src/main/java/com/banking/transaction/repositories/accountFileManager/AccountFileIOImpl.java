package com.banking.transaction.repositories.accountFileManager;

import java.io.File;
import java.util.List;

import com.banking.transaction.entities.Account;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class AccountFileIOImpl implements AccountFileIO{

    ObjectMapper mapper=new ObjectMapper();
    File accountFile=new File("AccountDetails.json");
    

    public AccountFileIOImpl(){
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serializeAccount(List<Account> accounts){
        try{
            mapper.writeValue(accountFile,accounts);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> deserializeAccount(){
        try {
            List<Account> accounts=mapper.readValue(accountFile,new TypeReference<List<Account>>() {});
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

  
}
