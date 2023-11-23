package com.ineutm.backend.evaluaciones.expose.service;

import com.ineutm.backend.evaluaciones.expose.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    ResponseEntity<UserDto> getUserByNumberDocument(String numberDocument);
}
