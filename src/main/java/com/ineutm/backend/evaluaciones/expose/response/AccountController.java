package com.ineutm.backend.evaluaciones.expose.response;

import com.ineutm.backend.evaluaciones.expose.dto.UserDto;
import com.ineutm.backend.evaluaciones.expose.dto.UserRequest;
import com.ineutm.backend.evaluaciones.expose.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
@Slf4j
public class AccountController {

    private final ClientService clientService;

    @GetMapping("/{user-identity}")
    public Mono<String> getAllAccounts(@PathVariable("user-identity") String userIdentity) {
        return Mono.empty();
    }

    @GetMapping("/{numberDocument}/{email}")
    public ResponseEntity<UserDto> getUserByNumberDocument(@PathVariable String numberDocument,
                                                           @PathVariable String email) {
        validateUserRequest(numberDocument, email);

        return clientService.getUserByNumberDocument(numberDocument);
    }

    @PostMapping
    public ResponseEntity<UserDto> getUserByNumberDocument(@RequestBody UserRequest userRequest) {
        validateUserRequest(userRequest.getNumberDocument(), userRequest.getEmail());

        return clientService.getUserByNumberDocument(userRequest.getNumberDocument());
    }

    private void validateUserRequest(String numberDocument, String email) {
        if (!numberDocument.matches("\\d{1,8}")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Número de documento inválido");
        }
        if (!email.matches("[\\w\\.]+@[\\w\\.]+\\.com\\.pe")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Correo electrónico inválido");
        }
    }
}
