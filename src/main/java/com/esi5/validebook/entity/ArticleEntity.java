package com.esi5.validebook.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class ArticleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Long idtheme;
    private Long idlangue;
    private Date dateajout;
    private Long iduserajout;
    private Long iduservalide;
    private String references;
    private Long idlivre;
    private Long idtypelivre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdtheme() {
        return idtheme;
    }

    public void setIdtheme(Long idtheme) {
        this.idtheme = idtheme;
    }

    public Long getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(Long idlangue) {
        this.idlangue = idlangue;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    public Long getIduserajout() {
        return iduserajout;
    }

    public void setIduserajout(Long iduserajout) {
        this.iduserajout = iduserajout;
    }

    public Long getIduservalide() {
        return iduservalide;
    }

    public void setIduservalide(Long iduservalide) {
        this.iduservalide = iduservalide;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public Long getIdlivre() {
        return idlivre;
    }

    public void setIdlivre(Long idlivre) {
        this.idlivre = idlivre;
    }

    public Long getIdtypelivre() {
        return idtypelivre;
    }

    public void setIdtypelivre(Long idtypelivre) {
        this.idtypelivre = idtypelivre;
    }
}
