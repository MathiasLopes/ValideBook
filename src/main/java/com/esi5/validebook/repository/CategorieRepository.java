package com.esi5.validebook.repository;

import com.esi5.validebook.entity.CategorieEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity, Long>{
    
}
