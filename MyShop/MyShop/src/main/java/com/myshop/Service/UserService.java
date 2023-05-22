package com.myshop.Service;

import com.myshop.Bean.User;

public interface UserService {
    Boolean checkUserName(String userName);

    User findById(String id);

    Iterable<User> findAll();

    void save(User user);
}
