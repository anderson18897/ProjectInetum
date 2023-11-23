package com.ineutm.backend.evaluaciones.expose.repository;

import com.ineutm.backend.evaluaciones.expose.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNumberDocument(String numberDocument);
}
