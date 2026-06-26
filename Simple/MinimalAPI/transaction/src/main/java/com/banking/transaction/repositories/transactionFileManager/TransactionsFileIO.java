package com.banking.transaction.repositories.transactionFileManager;

import com.banking.transaction.entities.Transaction;
import java.util.List;

public interface TransactionsFileIO {
    void serializeTransaction(List<Transaction> transactions);
    List<Transaction> deserializeTransaction();
}
