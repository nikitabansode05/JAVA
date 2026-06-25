package com.example.employeeapi;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class EmployeeHandler {

    private final EmployeeRepository repository;

    public EmployeeHandler(EmployeeRepository repository) {
        this.repository = repository;
    }

    public ServerResponse getAll(ServerRequest request) {

        return ServerResponse.ok().body(repository.findAll());
    }

    public ServerResponse getById(ServerRequest request) {
        Long id =Long.parseLong(request.pathVariable("id"));
        Employee employee =repository.findById(id);
        if (employee == null) {
            return ServerResponse.notFound().build();
        }
        return ServerResponse.ok().body(employee);
    }

    public ServerResponse create(ServerRequest request) {

        try{
        Employee employee =request.body(Employee.class);
        repository.save(employee);
        return ServerResponse.ok().body(employee);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ServerResponse update(ServerRequest request) {
        try{
        Long id = Long.parseLong(request.pathVariable("id"));
        Employee employee =request.body(Employee.class);
        Employee updated = new Employee(id,employee.name(),employee.salary());
        repository.save(updated);
        return ServerResponse.ok().body(updated);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ServerResponse delete(ServerRequest request) {

        Long id =Long.parseLong(request.pathVariable("id"));
        repository.delete(id);
        return ServerResponse.noContent().build();
    }
}