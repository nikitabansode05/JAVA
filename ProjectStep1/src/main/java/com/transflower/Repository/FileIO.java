package com.transflower.Repository;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transflower.Entity.QuestionBank;

public class FileIO {
    private static ObjectMapper mapper=new ObjectMapper();

    public static void serialize(QuestionBank questionBank){
        try {
            mapper.writeValue(new File("QuestionBank.json"), questionBank);;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static QuestionBank Deserialize(String jsonString){
        try {
            return mapper.readValue(new File("QuestionBank.json"), QuestionBank.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
