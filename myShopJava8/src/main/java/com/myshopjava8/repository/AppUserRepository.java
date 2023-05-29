package com.myshopjava8.repository;


import com.myshopjava8.bean.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
//    AppUser findAppUsersByUserName(String userName);

    AppUser findByUserName(String userName);
}
