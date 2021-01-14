package com.esi5.validebook.repository;

import com.esi5.validebook.entity.AuteurEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<AuteurEntity, Long> {
    
}
