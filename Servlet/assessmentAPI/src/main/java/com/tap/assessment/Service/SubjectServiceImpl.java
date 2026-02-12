package com.tap.assessment.Service;

import java.util.List;
import com.tap.assessment.Entity.SubjectModel;
import com.tap.assessment.Repository.SubjectRepository;

public class SubjectServiceImpl implements SubjectService{

    SubjectRepository sr = new SubjectRepository();

    public SubjectServiceImpl(){
      
    }
    public SubjectServiceImpl(SubjectRepository sr){
        this.sr=sr;
    }

    public List<SubjectModel> getAllSubjects(){
        return sr.deserialize();
    }
}