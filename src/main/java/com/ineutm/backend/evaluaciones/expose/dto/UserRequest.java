package com.ineutm.backend.evaluaciones.expose.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class UserRequest {
    @Pattern(regexp = "\\d{1,8}", message = "Número de documento inválido")
    private String numberDocument;

    @Email(message = "Formato de correo electrónico inválido")
    @Pattern(regexp = "[\\w\\.]+@[\\w\\.]+\\.com\\.pe", message = "Correo electrónico inválido")
    private String email;
}
