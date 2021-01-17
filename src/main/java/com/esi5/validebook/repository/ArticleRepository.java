package com.esi5.validebook.repository;

import java.util.List;
import com.esi5.validebook.entity.ArticleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long>{
    
    List<ArticleEntity> findByIdlivre(long idlivre);

}
