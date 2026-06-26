package com.banking.transaction.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import java.util.List;

import com.banking.transaction.entities.Transaction;
import com.banking.transaction.entities.Account;
import com.banking.transaction.dtos.AccountRequest;

import com.banking.transaction.transactionManagers.AccountDepartment;
import reactor.core.publisher.Mono;

@Component
public class AccountHandler {

    private final AccountDepartment accountDepartment;

    public AccountHandler(AccountDepartment accountDepartment){
        this.accountDepartment = accountDepartment;
    }

    public Mono<ServerResponse> getAccountDetails(ServerRequest request){
        int accountNo = Integer.parseInt(request.pathVariable("accountNo"));
        Account account = accountDepartment.showAccountDetails(accountNo);

        if (account == null) {
            return ServerResponse.notFound().build();
        }
        return ServerResponse.ok().bodyValue(account);
    }

    public Mono<ServerResponse> credit(ServerRequest request){
        int accountNo = Integer.parseInt(request.pathVariable("accountNo"));
        double amount = Double.parseDouble(request.pathVariable("amount"));
        boolean status = accountDepartment.credit(amount, accountNo);

        if (status) {
            Account updatedAccount = accountDepartment.showAccountDetails(accountNo);
            return ServerResponse.ok().bodyValue(updatedAccount);
        } else {
            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .bodyValue("Something went wrong");
        }
    }

    public Mono<ServerResponse> debit(ServerRequest request){
        int accountNo = Integer.parseInt(request.pathVariable("accountNo"));
        double amount = Double.parseDouble(request.pathVariable("amount"));
        boolean status = accountDepartment.debit(amount, accountNo);

        if (status) {
            Account updatedAccount = accountDepartment.showAccountDetails(accountNo);
            return ServerResponse.ok().bodyValue(updatedAccount);
        } else {
            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .bodyValue("Something went wrong");
        }
    }

    public Mono<ServerResponse> createAccount(ServerRequest request){
      return request.bodyToMono(AccountRequest.class)
      .flatMap(body->{
        int accountNo=body.getAccountNo();
        String name=body.getName();
        double balance=body.getBalance();

        boolean status=accountDepartment.createAccount(accountNo,name,balance);
        if(status){
            return ServerResponse.ok().bodyValue("Account created successfully");
        }else{
            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .bodyValue("Something went wrong");
        }
      });
    }

    public Mono<ServerResponse> getStatement(ServerRequest request){
        int accountNo = Integer.parseInt(request.pathVariable("accountNo"));
        List<Transaction> statement=accountDepartment.getStatement(accountNo);
        return ServerResponse.ok().bodyValue(statement);
    }

    public Mono<ServerResponse> transaction(ServerRequest request){
        int fromAccountNo = Integer.parseInt(request.pathVariable("fromAccountNo"));
        int toAccountNo = Integer.parseInt(request.pathVariable("toAccountNo"));
        double amount = Double.parseDouble(request.pathVariable("amount"));
        boolean status=accountDepartment.transaction(fromAccountNo,toAccountNo,amount);
        if(status){
            return ServerResponse.ok().bodyValue("Transaction succed!!!");
        }else{
            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .bodyValue("Something went wrong");
        }
    }

    public Mono<ServerResponse> applyInterest(ServerRequest request){
        int accountNo = Integer.parseInt(request.pathVariable("accountNo"));
        double interest = Double.parseDouble(request.pathVariable("interest"));
        double appliedInterest=accountDepartment.applyInterest(accountNo,interest);
        return ServerResponse.ok().bodyValue("Applied Interest : "+appliedInterest);
    }

    public Mono<ServerResponse> applyInteresttoAll(ServerRequest request){
        double interest = Double.parseDouble(request.pathVariable("interest"));
        accountDepartment.applyInteresttoAll(interest);
        return ServerResponse.ok().bodyValue("Interest applied successfully");
    }
}
