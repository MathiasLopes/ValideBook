package com.esi5.validebook.repository;

import java.util.List;
import com.esi5.validebook.entity.ExtraitEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraitRepository extends JpaRepository<ExtraitEntity, Long> {
    
    List<ExtraitEntity> findByIdlivre(long idlivre);

}
