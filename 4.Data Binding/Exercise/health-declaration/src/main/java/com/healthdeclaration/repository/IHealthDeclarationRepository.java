package com.healthdeclaration.repository;


import com.healthdeclaration.model.HealthDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IHealthDeclarationRepository extends JpaRepository<HealthDeclaration,Integer> {
    @Modifying
    @Query(value = "select * from health_declaration  where fullName like :name", nativeQuery = true)
    List<HealthDeclaration> findHealthDeclarationByName(@Param(value = "name") String name);
}
