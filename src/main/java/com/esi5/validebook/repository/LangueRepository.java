package com.esi5.validebook.repository;

import java.util.List;

import com.esi5.validebook.entity.LangueEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LangueRepository extends JpaRepository<LangueEntity, Long>  {
    
    @Query(value="select * from langues where langue like :langue", nativeQuery=true)
    List<LangueEntity> getWithLangue(@Param("langue") String langue);

}
