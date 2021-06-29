package com.esi5.validebook.repository;

import java.util.List;

import com.esi5.validebook.entity.CommentaireEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<CommentaireEntity, Long> {
    
    List<CommentaireEntity> findByIdlivre(long idlivre);

}
