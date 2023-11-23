package com.ineutm.backend.evaluaciones.expose.service.impl;

import com.ineutm.backend.evaluaciones.expose.dao.AccountDao;
import com.ineutm.backend.evaluaciones.expose.dao.TransactionDao;
import com.ineutm.backend.evaluaciones.expose.dao.UserDao;
import com.ineutm.backend.evaluaciones.expose.dto.AccountDto;
import com.ineutm.backend.evaluaciones.expose.dto.TransactionDto;
import com.ineutm.backend.evaluaciones.expose.dto.UserDto;
import com.ineutm.backend.evaluaciones.expose.model.Account;
import com.ineutm.backend.evaluaciones.expose.model.Transaction;
import com.ineutm.backend.evaluaciones.expose.model.User;
import com.ineutm.backend.evaluaciones.expose.service.ClientService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.stream.Collectors;
import static com.ineutm.backend.evaluaciones.expose.common.Constant.PREMIUM;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {
    private final UserDao userDao;
    private final AccountDao accountDao;
    private final TransactionDao transactionDao;

    public ClientServiceImpl(UserDao userDao, AccountDao accountDao, TransactionDao transactionDao) {
        this.userDao = userDao;
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
    }

    @SneakyThrows
    @Override
    public ResponseEntity<UserDto> getUserByNumberDocument(String numberDocument) {
        log.info("dni recibido: " + maskDni(numberDocument));

        val user = userDao.findByNumberDocument("dni-" + numberDocument);
        val userDto = convertToUserDto(user);
        val accounts = accountDao.findByUserId(user.getId());
        List<AccountDto> accountsDto;

        if (PREMIUM.equals(user.getType())) {
            accountsDto = accounts.stream()
                    .map(this::convertToAccountDtoWithTransactions)
                    .collect(Collectors.toList());
        } else {
            accountsDto = accounts.stream()
                    .map(this::convertToAccountDtoEmptyTransactions)
                    .collect(Collectors.toList());
        }

        userDto.setAccounts(accountsDto);

        return ResponseEntity.ok(userDto);
    }

//    private Mono<AccountDto> convertToAccountDtoWithTransactionsReactive(Account account) {
//        val accountDto = new AccountDto();
//        accountDto.setId(account.getId());
//        accountDto.setState(account.getState());
//        accountDto.setNumber(account.getNumber());
//
//        if (account.getUser() != null) {
//            accountDto.setUserId(account.getUser().getId());
//        }
//
//        return transactionReactiveDao.findByAccountId(account.getId())
//                .map(this::convertToTransactionDto)
//                .collectList()
//                .map(transactionsDto -> {
//                    accountDto.setTransactions(transactionsDto);
//                    return accountDto;
//                });
//    }

    private AccountDto convertToAccountDtoWithTransactions(Account account) {
        val accountDto = new AccountDto();

        accountDto.setId(account.getId());
        accountDto.setState(account.getState());
        accountDto.setNumber(account.getNumber());

        if (account.getUser() != null) {
            accountDto.setUserId(account.getUser().getId());
        }

        val transactions = transactionDao.findByAccountId(account.getId());
        val transactionsDto = transactions.stream()
                .map(this::convertToTransactionDto)
                .collect(Collectors.toList());
        accountDto.setTransactions(transactionsDto);

        return accountDto;
    }

    private UserDto convertToUserDto(User user) {
        val userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setNumberDocument(deletePrefNumberDocument(user.getNumberDocument()));
        userDto.setState(user.getState());
        userDto.setType(user.getType());

        return userDto;
    }

    private AccountDto convertToAccountDtoEmptyTransactions(Account account) {
        val accountDto = new AccountDto();

        accountDto.setId(account.getId());
        accountDto.setState(account.getState());
        accountDto.setNumber(account.getNumber());

        if (account.getUser() != null) {
            accountDto.setUserId(account.getUser().getId());
        }

        return accountDto;
    }

    private TransactionDto convertToTransactionDto(Transaction transaction) {
        val transactionDto = new TransactionDto();

        transactionDto.setId(transaction.getId());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setInterests(transaction.getInterests());

        if (transaction.getAccount() != null) {
            transactionDto.setAccountId(transaction.getAccount().getId());
        }

        return transactionDto;
    }

    private String maskDni(String dni) {
        return "XXXX" + dni.substring(4);
    }

    private String deletePrefNumberDocument(String numberDocument) {
        if (numberDocument != null && numberDocument.startsWith("dni-")) {
            return numberDocument.substring(4);
        }

        return numberDocument;
    }
}
