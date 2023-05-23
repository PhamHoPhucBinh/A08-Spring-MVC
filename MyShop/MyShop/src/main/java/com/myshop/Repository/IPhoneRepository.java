package com.myshop.Repository;

import com.myshop.Bean.Phone;
import com.myshop.Bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
    Page<Phone> findByPhoneNameLike(Pageable pageable, String name);

    Phone findByUser(User user);

    Phone findByPhoneName(String phoneName);
}
