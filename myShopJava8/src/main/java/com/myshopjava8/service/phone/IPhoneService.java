package com.myshopjava8.service.phone;


import com.myshopjava8.bean.Phone;

import java.util.Optional;

public interface IPhoneService {
    Iterable<Phone> findAll();

    Optional<Phone> findById(Integer phoneId);

    void save(Phone phone);

    void remove(Integer phoneId);
}
