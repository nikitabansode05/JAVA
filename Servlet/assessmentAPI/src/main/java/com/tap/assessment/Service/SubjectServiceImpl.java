package com.tap.assessment.Service;

import java.util.ArrayList;
import java.util.List;
import com.tap.assessment.Entity.SubjectModel;

public class SubjectServiceImpl implements SubjectService{
    SubjectModel sm;
    public SubjectServiceImpl(){

    }
    
    public SubjectServiceImpl(SubjectModel sm){
        this.sm=sm;
    }

    public List<SubjectModel> getAllSubjects(){
        SubjectModel subject1=new SubjectModel(1,"Physics");
        SubjectModel subject2=new SubjectModel(2,"Chemistry");
        SubjectModel subject3=new SubjectModel(3,"Maths");
        List<SubjectModel> subjects=new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        return subjects;
    }
}