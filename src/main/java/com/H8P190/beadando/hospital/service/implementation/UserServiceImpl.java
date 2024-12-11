package com.H8P190.beadando.hospital.service.implementation;

import com.H8P190.beadando.hospital.dao.UserDAO;
import com.H8P190.beadando.hospital.entity.User;
import com.H8P190.beadando.hospital.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public List<User> findAllDoctors() {
        List<User> users = userDAO.findAll();
        List<User> doctors = new ArrayList<User>();
        for (User user : users) {
            if (user.getRole() == User.Role.DOCTOR) {
                doctors.add(user);
            }
        }

        return doctors;
    }

    @Override
    public List<User> findAllPharmacists() {
        List<User> users = userDAO.findAll();
        List<User> pharmacists = new ArrayList<User>();
        for (User user : users) {
            if (user.getRole() == User.Role.PHARMACIST) {
                pharmacists.add(user);
            }
        }

        return pharmacists;
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public String deleteById(int id) {
        User user = userDAO.findById(id);

        if (user != null) {
            userDAO.deleteById(id);
            return "User deleted successfully";
        }

        return "User not found";
    }
}
