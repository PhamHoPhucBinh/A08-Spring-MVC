package com.myshop.Service;

import com.myshop.Bean.User;

public interface UserService {
    Boolean checkUserName(String userName);

    User findById(Integer id);

    Iterable<User> findAll();

    void save(User user);
}
