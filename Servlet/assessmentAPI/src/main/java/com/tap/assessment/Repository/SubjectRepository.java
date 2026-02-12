package com.tap.assessment.Repository;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tap.assessment.Entity.SubjectModel;

public class SubjectRepository {
    private ObjectMapper mapper=new ObjectMapper();

    public SubjectRepository(){

    }
    public void serialize(SubjectModel subject){
        try{
           mapper.writeValue(new File("src/main/resources/subject.json"), subject);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<SubjectModel> deserialize(){
        List<SubjectModel> subjectList=new ArrayList<>();
        try{
            InputStream input = getClass().getClassLoader().getResourceAsStream("subject.json");
            subjectList = mapper.readValue(input,new TypeReference<List<SubjectModel>>() {});
        }catch(Exception e){
            e.printStackTrace();
        }
        return subjectList;
    }
}
