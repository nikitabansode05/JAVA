package com.banking.transaction.repositories.accountFileManager;

import java.util.List;

import com.banking.transaction.entities.Account;

public interface AccountFileIO{
    void serializeAccount(List<Account> accounts);
    List<Account> deserializeAccount();
   
}
