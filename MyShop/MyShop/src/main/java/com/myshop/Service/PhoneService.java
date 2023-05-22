package com.myshop.Service;

import com.myshop.Bean.Phone;
import com.myshop.Bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {
    Page<Phone> findAll(Pageable pageable);

    Page<Phone> findByName(Pageable pageable, String phoneName);

    Phone findByPhoneName(String phoneName);

    Iterable<Phone> findAllNotPage();

    Phone findById(Integer phoneId);

    void save(Phone phone);

    void delete(Phone phone);
}
