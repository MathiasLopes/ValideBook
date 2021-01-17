package com.esi5.validebook.repository;

import java.util.List;

import com.esi5.validebook.entity.EditeurHasBookEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditeurHasBookRepository extends JpaRepository<EditeurHasBookEntity, Long> {
    
    List<EditeurHasBookEntity> findByIdlivre(long idlivre);

}
