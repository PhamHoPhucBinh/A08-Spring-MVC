package com.myshop.Service.Impl;

import com.myshop.Bean.User;
import com.myshop.Repository.IUserRepository;
import com.myshop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Boolean checkUserName(String userName) {
        return userRepository.existsUserByUserName(userName);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}