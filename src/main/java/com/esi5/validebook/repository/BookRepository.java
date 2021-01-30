package com.esi5.validebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.esi5.validebook.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query(value="select * from book where book.datevalidation IS NOT NULL ORDER BY book.id DESC LIMIT :limit", nativeQuery=true)
    List<BookEntity> getXLastBookValidate(@Param("limit") Integer limit);

    @Query(value="select * from book where book.datevalidation IS NOT NULL and titre like :titre", nativeQuery=true)
    List<BookEntity> getWithTitre(@Param("titre") String titre);

    @Query(value="select * from book, langues where book.datevalidation IS NOT NULL and book.idlangue = langues.id and langues.langue like :langue", nativeQuery=true)
    List<BookEntity> getWithLangue(@Param("langue") String langue);

    @Query(value="select * from book, langues where book.datevalidation IS NOT NULL and book.idlangue = langues.id and book.titre like :titre and langues.langue like :langue", nativeQuery=true)
    List<BookEntity> getWithTitreAndLangue(@Param("titre") String titre, @Param ("langue") String langue);

    @Query(value="select * from book where book.datevalidation IS NOT NULL and datepublication >= :datepublicationdebut and datepublication < :datepublicationfin", nativeQuery=true)
    List<BookEntity> getWithDatePublication(@Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin);

    @Query(value="select * from book where book.datevalidation IS NOT NULL and titre like :titre and datepublication >= :datepublicationdebut and datepublication < :datepublicationfin", nativeQuery=true)
    List<BookEntity> getWithTitreAndDatePublication(@Param("titre") String titre, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin);

    @Query(value="select * from book, langues where book.datevalidation IS NOT NULL and book.idlangue = langues.id and langues.langue like :langue and book.datepublication >= :datepublicationdebut and book.datepublication < :datepublicationfin", nativeQuery=true)
    List<BookEntity> getWithLangueAndDatePublication(@Param("langue") String langue, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin);

    @Query(value="select * from book, langues where book.datevalidation IS NOT NULL and book.idlangue = langues.id and langues.langue like :langue and book.titre like :titre and book.datepublication >= :datepublicationdebut and book.datepublication < :datepublicationfin", nativeQuery=true)
    List<BookEntity> getWithTitreAndLangueAndDatePublication(@Param("titre") String titre, @Param("langue") String langue, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin);

}
