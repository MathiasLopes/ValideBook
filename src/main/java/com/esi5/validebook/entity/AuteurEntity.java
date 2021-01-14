package com.esi5.validebook.entity;

import java.util.Date;
import javax.persistence.*;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "auteur")
public class AuteurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date datenaissance;
    @Nullable
    private Date datedeces;
    private String lieuDeNaissance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public Date getDatedeces() {
        return datedeces;
    }

    public void setDatedeces(Date datedeces) {
        this.datedeces = datedeces;
    }

    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }

    public void setLieuDeNaissance(String lieuDeNaissance) {
        this.lieuDeNaissance = lieuDeNaissance;
    }

}
