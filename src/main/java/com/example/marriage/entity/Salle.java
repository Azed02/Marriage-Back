package com.example.marriage.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "huwa")
    @SequenceGenerator(name = "huwa",allocationSize = 1)
    private Long id;
    private String nom;
    private String adresse;
    private String ville;
    private int capacite;

    @OneToMany(mappedBy = "salle")
    private List<Marriage> marriages;

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Marriage> getMarriages() {
        return marriages;
    }

    public void setMarriages(List<Marriage> marriages) {
        this.marriages = marriages;
    }

    public Salle(Long id, String nom, String adresse, String ville, int capacite) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.capacite = capacite;
    }
    public Salle(){

    }
}
