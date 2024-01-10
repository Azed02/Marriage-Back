package com.example.marriage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
public class Invite extends Personne{
    @Enumerated(EnumType.STRING)
    private StatutInvit statutInvit;

    @ManyToMany()
    @JsonIgnore
    @JoinTable(
            name = "marriage_invite",
            joinColumns=
                    @JoinColumn(name = "invite"),
            inverseJoinColumns =
                    @JoinColumn(name = "marriage")

    )
    private List<Marriage> marriages;


    public Invite(Long id, String CIN, String nom, String prenom, StatutInvit statutInvit) {
        super(id, CIN, nom, prenom);
        this.statutInvit = statutInvit;
    }

    public Invite(StatutInvit statutInvit) {
        this.statutInvit = statutInvit;
    }

    public Invite() {

    }

    public StatutInvit getStatutInvit() {
        return statutInvit;
    }

    public void setStatutInvit(StatutInvit statutInvit) {
        this.statutInvit = statutInvit;
    }

    public List<Marriage> getMarriages() {
        return marriages;
    }

    public void setMarriages(List<Marriage> marriages) {
        this.marriages = marriages;
    }
}
