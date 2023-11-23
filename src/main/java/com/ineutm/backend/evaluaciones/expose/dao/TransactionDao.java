package com.ineutm.backend.evaluaciones.expose.dao;

import com.ineutm.backend.evaluaciones.expose.model.Transaction;
import java.util.List;

public interface TransactionDao {
    List<Transaction> findByAccountId(Long accountId);
}
