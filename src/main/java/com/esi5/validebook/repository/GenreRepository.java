package com.esi5.validebook.repository;

import com.esi5.validebook.entity.GenreEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long>{
    
}
