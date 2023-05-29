package com.myshopjava8.service.phone;

import com.myshopjava8.bean.Phone;
import com.myshopjava8.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Iterable<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(Integer phoneId) {
        return phoneRepository.findById(phoneId);
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void remove(Integer phoneId) {
        phoneRepository.deleteById(phoneId);
    }
}
