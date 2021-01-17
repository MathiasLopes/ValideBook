package com.esi5.validebook.entity.ForWebRequest;

import java.util.List;

import com.esi5.validebook.entity.ArticleEntity;
import com.esi5.validebook.entity.AuteurEntity;
import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.entity.CategorieEntity;
import com.esi5.validebook.entity.CollectionEntity;
import com.esi5.validebook.entity.CommentaireEntity;
import com.esi5.validebook.entity.EditeurEntity;
import com.esi5.validebook.entity.ExtraitEntity;
import com.esi5.validebook.entity.GenreEntity;
import com.esi5.validebook.entity.LangueEntity;

public class BookEntityRequest extends BookEntity {

    private GenreEntity genre;
    private CategorieEntity categorie;
    private LangueEntity langue;
    private List<AuteurEntity> listAuteurs;
    private List<CommentaireEntity> listCommentaires;
    private List<EditeurEntity> listEditeurs;
    private List<ExtraitEntity> listExtraits;
    private List<ArticleEntity> listArticles;
    private List<CollectionEntity> listCollections;

    public LangueEntity getLangue() {
        return langue;
    }

    public void setLangue(LangueEntity langue) {
        this.langue = langue;
    }

    public CategorieEntity getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEntity categorie) {
        this.categorie = categorie;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public List<ExtraitEntity> getListExtraits() {
        return listExtraits;
    }

    public void setListExtraits(List<ExtraitEntity>  listExtraits) {
        this.listExtraits = listExtraits;
    }

    public List<ArticleEntity> getListArticles() {
        return listArticles;
    }

    public void setListArticles(List<ArticleEntity> listArticles) {
        this.listArticles = listArticles;
    }

    public void setListArticles(long id) {
        //this.listArticles = listArticles;
    }

    public List<CollectionEntity> getListCollections() {
        return listCollections;
    }

    public void setListCollections(List<CollectionEntity> listCollections) {
        this.listCollections = listCollections;
    }

    public void setListCollections(long id) {
        //this.listCollections = listCollections;
    }

    public List<AuteurEntity> getListAuteurs() {
        return listAuteurs;
    }

    public void setListAuteurs(List<AuteurEntity> listAuteurs) {
        this.listAuteurs = listAuteurs;
    }

    public void setListAuteurs(long id) {
        //this.listAuteurs = listAuteurs;
    }

    public List<CommentaireEntity> getListCommentaires() {
        return listCommentaires;
    }

    public void setListCommentaires(List<CommentaireEntity> listCommentaires) {
        this.listCommentaires = listCommentaires;
    }

    public void setListCommentaires(long id) {
        //this.listCommentaires = listCommentaires;
    }

    public List<EditeurEntity> getListEditeurs() {
        return listEditeurs;
    }

    public void setListEditeurs(List<EditeurEntity> listEditeurs) {
        this.listEditeurs = listEditeurs;
    }

    public void setListEditeurs(long id) {
        //this.listEditeurs = listEditeurs;
    }

}
