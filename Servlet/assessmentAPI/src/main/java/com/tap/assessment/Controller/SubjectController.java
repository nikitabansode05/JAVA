package com.tap.assessment.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tap.assessment.Entity.IOCContainer;
import com.tap.assessment.Entity.SubjectModel;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.tap.assessment.Service.SubjectService;

@WebServlet("/api/subjects")
public class SubjectController extends HttpServlet{
    private SubjectService subjectService;

    @Override
    public void init(){
        subjectService=IOCContainer.getBean(SubjectService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
    throws IOException{
        PrintWriter out=response.getWriter();
        
        List<SubjectModel> subjects=subjectService.getAllSubjects();

        for(SubjectModel subject:subjects){
            out.println(subject);
        }

    }
}
