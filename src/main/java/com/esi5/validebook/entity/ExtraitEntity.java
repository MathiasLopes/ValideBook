package com.esi5.validebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "extrait")
public class ExtraitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String extrait;
    private Long idlivre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtrait() {
        return extrait;
    }

    public void setExtrait(String extrait) {
        this.extrait = extrait;
    }

    public Long getIdlivre() {
        return idlivre;
    }

    public void setIdlivre(Long idlivre) {
        this.idlivre = idlivre;
    }

}
