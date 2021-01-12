package com.esi5.validebook.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.esi5.validebook.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    

}
