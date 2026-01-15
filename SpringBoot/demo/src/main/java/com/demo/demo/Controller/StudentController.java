package com.demo.demo.Controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.Entity.*;
import com.demo.demo.Repository.CSVFileIO;
import com.demo.demo.Service.*;

@RestController
public class StudentController {
    
    @Autowired
    StudentDashboardService sds;
        @Autowired

    CSVFileIOService fsvc;
    
    @GetMapping("/api/admin/users/role-summary")
    public List<Response> userByRole(){
        return sds.getUserByRoleSvc();
    }

    @GetMapping("/api/csv/data")
    public List<FileEntity> read() throws FileNotFoundException{
        return fsvc.read();
    }

}
