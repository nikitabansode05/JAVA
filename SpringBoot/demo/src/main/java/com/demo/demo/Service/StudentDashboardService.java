package com.demo.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.demo.Entity.Response;
import com.demo.demo.Repository.StudentDashboard;

@Service
public class StudentDashboardService {

    @Autowired
    StudentDashboard sdRepo;

    public List<Response> getUserByRoleSvc(){
        return sdRepo.getUserByRole();
    }
    
}
