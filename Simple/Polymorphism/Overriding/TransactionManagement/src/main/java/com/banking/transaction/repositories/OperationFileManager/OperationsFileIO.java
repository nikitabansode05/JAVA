package com.banking.transaction.repositories.OperationFileManager;

import com.banking.transaction.entities.Operation;
import java.util.List;

public interface OperationsFileIO {
    void serializeOperation(List<Operation> operations);
    List<Operation> deserializeOperation();
}
