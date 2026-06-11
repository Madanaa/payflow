package com.payflow.service.impl;

import com.payflow.entity.User;
import com.payflow.repository.UserRepository;
import com.payflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        // At startup, Spring creates a UserRepository bean and injects it here so this service can call database methods.
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUpiId(String upiId) {
        return userRepository.findByUpiId(upiId);
    }

    @Override
    public List<User> getHighBalanceUsers(Double minBalance) {
        return userRepository.findUsersWithBalanceGreaterThan(minBalance);
    }
}
