package com.banking.transaction.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.function.RouterFunction;
// import org.springframework.web.servlet.function.RouterFunctions;
// import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;


import com.banking.transaction.handlers.AccountHandler;

@Configuration
public class AccountAPIRouter {
    @Bean
    public RouterFunction<ServerResponse> routes(AccountHandler handler){
           return RouterFunctions.route(GET("/api/account/{accountNo}/details"), handler::getAccountDetails)
                              .andRoute(PUT("/api/account/{accountNo}/credit/{amount}"), handler::credit)
                              .andRoute(PUT("/api/account/{accountNo}/debit/{amount}"), handler::debit)
                              .andRoute(POST("/api/account/create"),handler::createAccount)
                              .andRoute(GET("/api/account/statement/{accountNo}"),handler::getStatement)
                              .andRoute(PUT("/api/fromaccount/{fromAccountNo}/toaccount/{toAccountNo}/amount/{amount}"), handler::transaction)
                              .andRoute(PUT("/api/account/{accountNo}/interest/{interest}"), handler::applyInterest)
                              .andRoute(PUT("/api/account/interest/{interest}"), handler::applyInteresttoAll);
    }
}
