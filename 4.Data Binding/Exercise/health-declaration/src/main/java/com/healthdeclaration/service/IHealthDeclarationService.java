package com.healthdeclaration.service;

import com.healthdeclaration.model.HealthDeclaration;

import java.util.List;
import java.util.Optional;

public interface IHealthDeclarationService {

    void save(HealthDeclaration healthDeclaration);

    HealthDeclaration getHealthDeclarationById(Integer id);

    List<HealthDeclaration> findAll();

    Optional<HealthDeclaration> findById(Integer id);


}
