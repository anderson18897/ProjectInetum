package com.ineutm.backend.evaluaciones.expose.dto;

import lombok.Data;

@Data
public class TransactionDto {
    private Long id;
    private Long accountId;
    private String description;
    private Double interests;
}
