package com.esi5.validebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "editeurhasbook")
public class EditeurHasBookEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idediteur;
    private Long idlivre;

    public Long getIdediteur() {
        return idediteur;
    }

    public void setIdediteur(Long idediteur) {
        this.idediteur = idediteur;
    }

    public Long getIdlivre() {
        return idlivre;
    }

    public void setIdlivre(Long idlivre) {
        this.idlivre = idlivre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
