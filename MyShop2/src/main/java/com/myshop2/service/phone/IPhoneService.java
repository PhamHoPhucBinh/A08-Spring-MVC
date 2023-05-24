package com.myshop2.service.phone;

import com.myshop2.bean.Invoice;
import com.myshop2.bean.Phone;

import java.util.Optional;

public interface IPhoneService {
    Iterable<Phone> findAll();

    Optional<Phone> findById(Integer phoneId);

    void save(Phone phone);

    void remove(Integer phoneId);
}
