package com.ineutm.backend.evaluaciones.expose.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String numberDocument;
    private int state;
    private String type;
    private List<AccountDto> accounts;
}
