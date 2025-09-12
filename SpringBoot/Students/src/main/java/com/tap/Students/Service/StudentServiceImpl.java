package com.tap.students.Service;

import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.ArrayList;
import com.tap.students.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tap.students.Entity.*;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentRepository repo;

    
    public StudentServiceImpl(IStudentRepository repo){
        this.repo=repo;
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<Boolean> create(String name ,String email){
       return CompletableFuture.completedFuture(repo.create(name,email));
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<Boolean> update(String name,int id){
        return CompletableFuture.completedFuture(repo.update(name,id));
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<List<String>> display(){
        return CompletableFuture.completedFuture(repo.display());
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<Boolean> delete(int id){
        return CompletableFuture.completedFuture(repo.delete(id));
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<Student> getById(int id){
        return CompletableFuture.completedFuture(repo.getById(id));
    }
}
