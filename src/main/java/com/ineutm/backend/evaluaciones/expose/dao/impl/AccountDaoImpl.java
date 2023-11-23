package com.ineutm.backend.evaluaciones.expose.dao.impl;

import com.ineutm.backend.evaluaciones.expose.dao.AccountDao;
import com.ineutm.backend.evaluaciones.expose.model.Account;
import com.ineutm.backend.evaluaciones.expose.repository.AccountRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    private final AccountRepository accountRepository;

    public AccountDaoImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findByUserId(Long userId) {
        return accountRepository.findByUser_Id(userId);
    }
}
