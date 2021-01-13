package com.esi5.validebook.repository;

import com.esi5.validebook.entity.LangueEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangueRepository extends JpaRepository<LangueEntity, Long>  {
    
}
