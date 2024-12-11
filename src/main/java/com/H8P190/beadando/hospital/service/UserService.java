package com.H8P190.beadando.hospital.service;

import com.H8P190.beadando.hospital.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    List<User> findAllDoctors();

    List<User> findAllPharmacists();

    User findById(int id);

    User save(User user);

    String deleteById(int id);
}

