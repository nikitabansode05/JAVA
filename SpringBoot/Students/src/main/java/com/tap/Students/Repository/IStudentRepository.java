package com.tap.Students.Repository;

import com.tap.Students.Entity.Student;


public interface IStudentRepository {
    void create();
    void update();
    void display();
    void delete();
    Student getById(int id);
}
