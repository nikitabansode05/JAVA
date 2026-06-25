package com.banking.transaction;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TransactionApplication.class);
	}

}


// public class AccountRequest {
//     private int accountNo;
//     public int getAccountNo() { return accountNo; }
//     public void setAccountNo(int accountNo) { this.accountNo = accountNo; }
// }

// public Mono<ServerResponse> getAccountDetails(ServerRequest request) {
//     return request.bodyToMono(AccountRequest.class)
//         .flatMap(body -> {
//             int accNo = body.getAccountNo();
//             Account account = accountDepartment.showAccountDetails(accNo);
//             if (account == null) {
//                 return ServerResponse.notFound().build();
//             }
//             return ServerResponse.ok().bodyValue(account);
//         });
// }


// public Mono<ServerResponse> getAccountDetails(ServerRequest request) {
//     return request.bodyToMono(AccountRequest.class)
//         .flatMap(body -> {
//             int accNo = body.getAccountNo();
//             Account account = accountDepartment.showAccountDetails(accNo);
//             if (account == null) {
//                 return ServerResponse.notFound().build();
//             }
//             return ServerResponse.ok().bodyValue(account);
//         });
// }
