package com.esi5.validebook.repository;

import com.esi5.validebook.entity.CollectionHasBookEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionHasBookRepository extends JpaRepository<CollectionHasBookEntity, Long>{
    
}
