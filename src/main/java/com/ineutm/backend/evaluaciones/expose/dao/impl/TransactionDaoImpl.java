package com.ineutm.backend.evaluaciones.expose.dao.impl;

import com.ineutm.backend.evaluaciones.expose.dao.TransactionDao;
import com.ineutm.backend.evaluaciones.expose.model.Transaction;
import com.ineutm.backend.evaluaciones.expose.repository.TransactionRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao {
    private final TransactionRepository transactionRepository;

    public TransactionDaoImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        return transactionRepository.findByAccount_Id(accountId);
    }
}
