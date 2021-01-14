package com.esi5.validebook.repository;

import com.esi5.validebook.entity.TypeArticleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeArticleRepository extends JpaRepository<TypeArticleEntity, Long> {
    
}
