package com.tap.students.Repository;

import java.util.List;

public interface IStudentRepository {
    void create();
    void update();
    List<String> display();
    void delete();
}
