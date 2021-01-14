package com.esi5.validebook.entity.ForWebRequest;

import com.esi5.validebook.entity.AuteurEntity;
import com.esi5.validebook.entity.BookEntity;

public class BookEntityRequest extends BookEntity {

    private String langue;
    private String categorie;
    private AuteurEntity auteur;


    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public AuteurEntity getAuteur() {
        return auteur;
    }

    public void setAuteur(AuteurEntity auteur) {
        this.auteur = auteur;
    }

    

}
