package com.ineutm.backend.evaluaciones.expose.dao;

import com.ineutm.backend.evaluaciones.expose.model.User;

import java.util.List;

public interface UserDao {
    User findByNumberDocument(String numberDocument);
}
