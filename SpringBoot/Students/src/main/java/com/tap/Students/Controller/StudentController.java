package com.tap.Students.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.Students.Repository.StudentRepositoryImpl;


@RestController
public class StudentController {
   
    private StudentRepositoryImpl repo;

    public StudentController(StudentRepositoryImpl repo){
        this.repo=repo;
    }

    @GetMapping("/insert")
    public void insert(){
        repo.create();
    }

    @GetMapping("/update")
    public void update(){
        repo.update();
    }

    @GetMapping("/delete")
    public void delete(){
        repo.delete();
    }

    @GetMapping("/display")
    public void display(){
        repo.display();
    }

}
