package com.myshopjava8.repository;


import com.myshopjava8.bean.AppUser;
import com.myshopjava8.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByAppUser_UserName(String username);
}
