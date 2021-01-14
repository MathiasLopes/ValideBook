package com.esi5.validebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookhasauteur")
public class BookHasAuteurEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idlivre;
    private Long idauteur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdlivre() {
        return idlivre;
    }

    public void setIdlivre(Long idlivre) {
        this.idlivre = idlivre;
    }

    public Long getIdauteur() {
        return idauteur;
    }

    public void setIdauteur(Long idauteur) {
        this.idauteur = idauteur;
    }
}
