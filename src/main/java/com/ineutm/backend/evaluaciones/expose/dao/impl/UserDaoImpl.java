package com.ineutm.backend.evaluaciones.expose.dao.impl;

import com.ineutm.backend.evaluaciones.expose.dao.UserDao;
import com.ineutm.backend.evaluaciones.expose.model.User;
import com.ineutm.backend.evaluaciones.expose.repository.UserRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityNotFoundException;

@Repository
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByNumberDocument(String numberDocument) {
        return userRepository.findByNumberDocument(numberDocument)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
    }
}
