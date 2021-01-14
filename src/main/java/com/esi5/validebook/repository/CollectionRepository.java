package com.esi5.validebook.repository;

import com.esi5.validebook.entity.CollectionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionEntity, Long> {
    
}
