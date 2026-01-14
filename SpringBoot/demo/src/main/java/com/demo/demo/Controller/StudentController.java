package com.demo.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.Entity.Response;
import com.demo.demo.Service.StudentDashboardService;

@RestController
public class StudentController {
    
    @Autowired
    StudentDashboardService sds;
    
    @GetMapping("/api/admin/users/role-summary")
    public List<Response> userByRole(){
        return sds.getUserByRoleSvc();
    }
}
