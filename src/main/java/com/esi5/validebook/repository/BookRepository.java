package com.esi5.validebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.esi5.validebook.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    String selectAllBook = "select * from book";
    String bookOrderByDesc = " ORDER BY book.id DESC";
    String dateValidationIsNotNull = "book.datevalidation IS NOT NULL";
    String themeRelation = "book.idtheme = theme.id";
    String whereTitreLike = "book.titre like ";
    String langueRelation = "book.idlangue = langues.id";
    String whereLangueLike = "langues.langue like ";
    String whereDatePublicationPart1 = "book.datepublication >= ";
    String whereDatePublicationPart2 = "and book.datepublication < ";

    @Query(value= selectAllBook + " where " + dateValidationIsNotNull + " " + bookOrderByDesc + " LIMIT :limit", nativeQuery=true)
    List<BookEntity> getXLastBookValidate(@Param("limit") Integer limit);

    @Query(value= selectAllBook + ", langues where " + dateValidationIsNotNull + " and book.idlangue = langues.id and langues.langue like :langue " + bookOrderByDesc + " LIMIT :limit", nativeQuery=true)
    List<BookEntity> getXLastBookValidateWithLangue(@Param("langue") String langue, @Param("limit") Integer limit);

    @Query(value= selectAllBook + " book where " + dateValidationIsNotNull + " and titre like :titre " + bookOrderByDesc, nativeQuery=true)
    List<BookEntity> getWithTitre(@Param("titre") String titre);

    @Query(value= selectAllBook + ", langues where " + dateValidationIsNotNull + " and book.idlangue = langues.id and langues.langue like :langue " + bookOrderByDesc, nativeQuery=true)
    List<BookEntity> getWithLangue(@Param("langue") String langue);

    @Query(value= selectAllBook + ", langues where " + dateValidationIsNotNull + " and book.idlangue = langues.id and book.titre like :titre and langues.langue like :langue " + bookOrderByDesc, nativeQuery=true)
    List<BookEntity> getWithTitreAndLangue(@Param("titre") String titre, @Param ("langue") String langue);

    @Query(value= selectAllBook + " where " + dateValidationIsNotNull + " and datepublication >= :datepublicationdebut and datepublication < :datepublicationfin " + bookOrderByDesc, nativeQuery=true)
    List<BookEntity> getWithDatePublication(@Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin);

    @Query(value= selectAllBook + " where " + dateValidationIsNotNull + " and titre like :titre and datepublication >= :datepublicationdebut and datepublication < :datepublicationfin " + bookOrderByDesc, nativeQuery=true)
    List<BookEntity> getWithTitreAndDatePublication(@Param("titre") String titre, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin);

    @Query(value= selectAllBook + ", langues where " + dateValidationIsNotNull + " and book.idlangue = langues.id and langues.langue like :langue and book.datepublication >= :datepublicationdebut and book.datepublication < :datepublicationfin " + bookOrderByDesc, nativeQuery=true)
    List<BookEntity> getWithLangueAndDatePublication(@Param("langue") String langue, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin);

    @Query(value= selectAllBook + ", langues where " + dateValidationIsNotNull + " and book.idlangue = langues.id and langues.langue like :langue and book.titre like :titre and book.datepublication >= :datepublicationdebut and book.datepublication < :datepublicationfin " + bookOrderByDesc, nativeQuery=true)
    List<BookEntity> getWithTitreAndLangueAndDatePublication(@Param("titre") String titre, @Param("langue") String langue, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin);

    @Query(value= selectAllBook + ", theme where " + dateValidationIsNotNull + " and " + themeRelation + " and theme.nom like :theme " + bookOrderByDesc, nativeQuery = true)
    List<BookEntity> getWithTheme(@Param("theme") String theme);

    @Query(value= selectAllBook + ", theme where " + dateValidationIsNotNull + " and " + themeRelation + " and theme.nom like :theme and " +  whereTitreLike + " :titre " + bookOrderByDesc, nativeQuery = true)
    List<BookEntity> getWithThemeAndTitre(@Param("theme") String theme, @Param("titre") String titre);

    @Query(value= selectAllBook + ", theme, langues where " + dateValidationIsNotNull + " and " + themeRelation + " and theme.nom like :theme and " + langueRelation + " and " +  whereLangueLike + " :langue " + bookOrderByDesc, nativeQuery = true)
    List<BookEntity> getWithThemeAndLangue(@Param("theme") String theme, @Param("langue") String langue);
    
    @Query(value= selectAllBook + ", theme, langues where " + dateValidationIsNotNull + " and " + themeRelation + " and theme.nom like :theme and " + langueRelation + " and " +  whereLangueLike + " :langue and " + whereTitreLike + " :titre " + bookOrderByDesc, nativeQuery = true)
    List<BookEntity> getWithThemeAndTitreAndLangue(@Param("theme") String theme, @Param("titre") String titre, @Param("langue") String langue);

    @Query(value= selectAllBook + ", theme where " + dateValidationIsNotNull + " and " + themeRelation + " and theme.nom like :theme and " + whereDatePublicationPart1 + ":datepublicationdebut" + whereDatePublicationPart2 + ":datepublicationfin " + bookOrderByDesc, nativeQuery = true)
    List<BookEntity> getWithThemeAndDatePublication(@Param("theme") String theme, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin);

    @Query(value= selectAllBook + ", theme where " + dateValidationIsNotNull + " and " + themeRelation + " and theme.nom like :theme and " + whereDatePublicationPart1 + ":datepublicationdebut" + whereDatePublicationPart2 + ":datepublicationfin and " + whereTitreLike + " :titre " + bookOrderByDesc, nativeQuery = true)
    List<BookEntity> getWithThemeAndDatePublicationAndTitre(@Param("theme") String theme, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin, @Param("titre") String titre);
    
    @Query(value= selectAllBook + ", theme, langues where " + dateValidationIsNotNull + " and " + themeRelation + " and theme.nom like :theme and " + whereDatePublicationPart1 + ":datepublicationdebut" + whereDatePublicationPart2 + ":datepublicationfin and " + langueRelation + " and " +  whereLangueLike + " :langue " + bookOrderByDesc, nativeQuery = true)
    List<BookEntity> getWithThemeAndDatePublicationAndLangue(@Param("theme") String theme, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin, @Param("langue") String langue);
    
    @Query(value= selectAllBook + ", theme, langues where " + dateValidationIsNotNull + " and " + themeRelation + " and theme.nom like :theme and " + whereDatePublicationPart1 + ":datepublicationdebut" + whereDatePublicationPart2 + ":datepublicationfin and " + whereTitreLike + " :titre " + " and " + langueRelation + " and " +  whereLangueLike + " :langue " + bookOrderByDesc, nativeQuery = true)
    List<BookEntity> getWithThemeAndDatePublicationAndLangueAndTitre(@Param("theme") String theme, @Param("datepublicationdebut") String datepublicationdebut, @Param("datepublicationfin") String datepublicationfin, @Param("titre") String titre, @Param("langue") String langue);
    
}
