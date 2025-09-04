package com.tap.students.Repository;

import java.util.List;

import com.tap.students.Entity.Student;

public interface IStudentRepository {
    void create(String name,String email);
    void update(String name,int id);
    List<String> display();
    void delete(int id);
    Student getById(int id);
}
