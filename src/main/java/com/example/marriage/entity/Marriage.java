package com.example.marriage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Marriage {

    @Id
    private Long numero;
    private LocalDate date;
    private int nombreMinimumTemoin;
    private int capaciteMinimal;
    private int nombreMaxInviteEpoux;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "CIN_epoux")
    private Personne epoux;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "CIN_epouse")
    private Personne epouse;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @ManyToMany(mappedBy = "marriages")
    private List<Invite> invites;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNombreMinimumTemoin() {
        return nombreMinimumTemoin;
    }

    public void setNombreMinimumTemoin(int nombreMinimumTemoin) {
        this.nombreMinimumTemoin = nombreMinimumTemoin;
    }

    public int getCapaciteMinimal() {
        return capaciteMinimal;
    }

    public void setCapaciteMinimal(int capaciteMinimal) {
        this.capaciteMinimal = capaciteMinimal;
    }

    public int getNombreMaxInviteEpoux() {
        return nombreMaxInviteEpoux;
    }

    public void setNombreMaxInviteEpoux(int nombreMaxInviteEpoux) {
        this.nombreMaxInviteEpoux = nombreMaxInviteEpoux;
    }

    public Personne getEpoux() {
        return epoux;
    }

    public void setEpoux(Personne epoux) {
        this.epoux = epoux;
    }

    public Personne getEpouse() {
        return epouse;
    }

    public void setEpouse(Personne epouse) {
        this.epouse = epouse;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public List<Invite> getInvites() {
        return invites;
    }

    public void setInvites(List<Invite> invites) {
        this.invites = invites;
    }

    public Marriage(Long numero, LocalDate date, int nombreMinimumTemoin, int capaciteMinimal, int nombreMaxInviteEpoux) {
        this.numero = numero;
        this.date = date;
        this.nombreMinimumTemoin = nombreMinimumTemoin;
        this.capaciteMinimal = capaciteMinimal;
        this.nombreMaxInviteEpoux = nombreMaxInviteEpoux;
    }

    public Marriage(){

    }
}
