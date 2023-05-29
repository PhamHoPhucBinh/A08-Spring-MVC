package com.myshopjava8.repository;


import com.myshopjava8.bean.AppUser;
import com.myshopjava8.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
