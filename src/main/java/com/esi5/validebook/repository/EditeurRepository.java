package com.esi5.validebook.repository;

import com.esi5.validebook.entity.EditeurEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditeurRepository extends JpaRepository<EditeurEntity, Long> {
    
    

}
