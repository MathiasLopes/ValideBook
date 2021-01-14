package com.esi5.validebook.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String resume;
    private Date datepublication;
    private String motcles;

    private Integer idlangue;
    private Integer idcategorie;
    private Integer idgenre;
    private Integer idcommentaire;
    private Integer idedition;
    
    private Integer iduserajout;
    private Date dateajout;

    @Nullable
    private Integer iduservalide;

    @Nullable
    private Date datevalidation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(Integer idlangue) {
        this.idlangue = idlangue;
    }

    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getIduserajout() {
        return iduserajout;
    }

    public void setIduserajout(Integer iduserajout) {
        this.iduserajout = iduserajout;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    public Integer getIdcommentaire() {
        return idcommentaire;
    }

    public void setIdcommentaire(Integer idcommentaire) {
        this.idcommentaire = idcommentaire;
    }

    public Integer getIduservalide() {
        return iduservalide;
    }

    public void setIduservalide(Integer iduservalide) {
        this.iduservalide = iduservalide;
    }

    public Date getDatevalidation() {
        return datevalidation;
    }

    public void setDatevalidation(Date datevalidation) {
        this.datevalidation = datevalidation;
    }

    public Integer getIdgenre() {
        return idgenre;
    }

    public void setIdgenre(Integer idgenre) {
        this.idgenre = idgenre;
    }

    public Date getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Date datepublication) {
        this.datepublication = datepublication;
    }

    public Integer getIdedition() {
        return idedition;
    }

    public void setIdedition(Integer idedition) {
        this.idedition = idedition;
    }

    public String getMotcles() {
        return motcles;
    }

    public void setMotcles(String motcles) {
        this.motcles = motcles;
    }

}

