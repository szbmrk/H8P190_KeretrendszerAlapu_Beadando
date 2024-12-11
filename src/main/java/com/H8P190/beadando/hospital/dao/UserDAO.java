package com.H8P190.beadando.hospital.dao;

import com.H8P190.beadando.hospital.entity.User;
import java.util.List;

public interface UserDAO {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    void deleteById(int id);
}
