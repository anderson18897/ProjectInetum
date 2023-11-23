package com.ineutm.backend.evaluaciones.expose.dto;

import lombok.Data;
import java.util.List;

@Data
public class AccountDto {
    private Long id;
    private int state;
    private String number;
    private Long userId;
    private List<TransactionDto> transactions;
}
