package com.ineutm.backend.evaluaciones.expose.dao;

import com.ineutm.backend.evaluaciones.expose.model.Account;
import java.util.List;

public interface AccountDao {
    List<Account> findByUserId(Long userId);
}
