package com.banking.transaction.repositories.OperationFileManager;

import java.io.File;
import java.util.List;

import com.banking.transaction.entities.Operation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class OperationsFileIOImpl implements OperationsFileIO{

    ObjectMapper mapper=new ObjectMapper();
    File operationsFile=new File("Operations.json");
    
    public OperationsFileIOImpl(){
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serializeOperation(List<Operation> operations){
        try{
            mapper.writeValue(operationsFile,operations);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Operation> deserializeOperation(){
        try{
            List<Operation> operations = mapper.readValue(operationsFile, new TypeReference<List<Operation>>() {});
            return operations;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
