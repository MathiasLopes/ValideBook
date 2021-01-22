package com.esi5.validebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.esi5.validebook.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query(value=" select * from book where book.datevalidation IS NOT NULL ORDER BY book.id DESC LIMIT :limit", nativeQuery=true)
    List<BookEntity> getXLastBookValidate(@Param("limit") Integer limit);

}
