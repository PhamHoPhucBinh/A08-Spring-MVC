package com.myshop.Repository;

import com.myshop.Bean.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPhoneRepository extends JpaRepository<Phone,Integer> {
    List<Phone> findByPhoneName (String phoneName);
}
