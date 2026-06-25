package com.example.employeeapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class EmployeeRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(EmployeeHandler handler) {

        return RouterFunctions.route()

                .GET("/employees", handler::getAll)

                .GET("/employees/{id}",handler::getById)

                .POST("/employees",handler::create)

                .PUT("/employees/{id}",handler::update)

                .DELETE("/employees/{id}",handler::delete)

                .build();
    }
}