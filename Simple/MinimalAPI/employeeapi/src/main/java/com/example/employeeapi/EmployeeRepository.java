package com.example.employeeapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    private final Map<Long, Employee> db =  new ConcurrentHashMap<>();

    public List<Employee> findAll() {
        return new ArrayList<>(db.values());
    }

    public Employee findById(Long id) {
        return db.get(id);
    }

    public Employee save(Employee employee) {
        db.put(employee.id(), employee);
        return employee;
    }

    public void delete(Long id) {
        db.remove(id);
    }
}