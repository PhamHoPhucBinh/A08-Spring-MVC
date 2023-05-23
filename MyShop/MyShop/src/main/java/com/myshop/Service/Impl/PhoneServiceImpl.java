package com.myshop.Service.Impl;

import com.myshop.Bean.Phone;
import com.myshop.Repository.IPhoneRepository;
import com.myshop.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return phoneRepository.findAll(pageable);
    }

    @Override
    public Page<Phone> findByName(Pageable pageable, String phoneName) {
        return phoneRepository.findByPhoneNameLike(pageable, phoneName);
    }

    @Override
    public Phone findByPhoneName(String phoneName) {
        return phoneRepository.findByPhoneName(phoneName);
    }


    @Override
    public Iterable<Phone> findAllNotPage() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone findById(Integer phoneId) {
        return phoneRepository.findById(phoneId).orElse(null);
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void delete(Phone phone) {
        phoneRepository.delete(phone);
    }
}
