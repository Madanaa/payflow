package com.payflow.service;

import com.payflow.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> findByUpiId(String upiId);
    boolean upiIdExists(String upiId);
    List<User> getHighBalanceUsers(Double minBalance);
}
