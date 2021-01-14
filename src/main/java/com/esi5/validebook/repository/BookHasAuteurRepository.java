package com.esi5.validebook.repository;

import com.esi5.validebook.entity.BookHasAuteurEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookHasAuteurRepository extends JpaRepository<BookHasAuteurEntity, Long> {
    
}
