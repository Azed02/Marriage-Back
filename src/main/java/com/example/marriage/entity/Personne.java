package com.example.marriage.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CIN;
    private String nom;
    private String prenom;

    public Personne(Long id, String CIN, String nom, String prenom) {
        this.id = id;
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;

    }

    @OneToMany(mappedBy = "epoux")
    private List<Marriage> marriages_epoux;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personne(){}
    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Marriage> getMarriages_epoux() {
        return marriages_epoux;
    }

    public void setMarriages_epoux(List<Marriage> marriages_epoux) {
        this.marriages_epoux = marriages_epoux;
    }

    public List<Marriage> getMarriages_epouse() {
        return marriages_epouse;
    }

    public void setMarriages_epouse(List<Marriage> marriages_epouse) {
        this.marriages_epouse = marriages_epouse;
    }

    @OneToMany(mappedBy = "epouse")
    private  List<Marriage> marriages_epouse;

}
