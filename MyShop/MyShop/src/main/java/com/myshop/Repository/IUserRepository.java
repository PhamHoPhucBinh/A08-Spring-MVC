package com.myshop.Repository;

import com.myshop.Bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    Boolean existsUserByUserName(String user);
}
