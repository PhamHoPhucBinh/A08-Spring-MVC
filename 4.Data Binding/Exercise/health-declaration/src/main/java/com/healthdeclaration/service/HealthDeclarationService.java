package com.healthdeclaration.service;

import com.healthdeclaration.model.HealthDeclaration;
import com.healthdeclaration.repository.IHealthDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthDeclarationService implements IHealthDeclarationService{

    @Autowired
    private IHealthDeclarationRepository iHealthDeclarationRepository;
    public Optional<HealthDeclaration>  findById(Integer id) {
        return iHealthDeclarationRepository.findById(id);
    }
    @Override
    public void save(HealthDeclaration healthDeclaration) {

    }

    @Override
    public HealthDeclaration getHealthDeclarationById(Integer id) {
        return iHealthDeclarationRepository.findById(id).orElse(null);
    }
    @Override
    public List<HealthDeclaration> findAll() {
        return iHealthDeclarationRepository.findAll();
    }
}
