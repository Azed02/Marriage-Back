package com.example.marriage.service;

import com.example.marriage.entity.Marriage;
import com.example.marriage.entity.Personne;
import com.example.marriage.entity.Salle;
import com.example.marriage.repository.MarriageRepository;
import com.example.marriage.repository.PersonneRepository;
import com.example.marriage.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {

    @Autowired
    PersonneRepository personneRepository;

    @Autowired
    MarriageRepository marriageRepository;

    @Autowired
    SalleRepository salleRepository;

    public Optional<Personne> getPersonneById(Long id){
       return this.personneRepository.findById(id);
    }

    public List<Personne> getAllpersonne(){
        return this.personneRepository.findAll();
    }

    public  Personne savePersonne(Personne p){
        return this.personneRepository.save(p);
    }

    public void deletePersonneById(Long id){
        this.personneRepository.deleteById(id);
    }

    public void reserver(Long femme_id , Long homme_id, Marriage marriage){
        Optional<Personne> femmeOp= this.getPersonneById(femme_id);
        Optional<Personne> hommeOp = this.getPersonneById(homme_id);
        if(femmeOp.isPresent()&&hommeOp.isPresent()){
            Personne homme = hommeOp.get();
            Personne femme = femmeOp.get();
            List<Marriage> marriages_home = homme.getMarriages_epoux();
            if(marriages_home==null){
                marriages_home=new ArrayList<>();
            }
            marriages_home.add(marriage);
            List<Marriage> marriages_femme = femme.getMarriages_epouse();
            if(marriages_femme==null){
                marriages_femme=new ArrayList<>();
            }
            marriages_femme.add(marriage);
            homme.setMarriages_epoux(marriages_home);
            femme.setMarriages_epouse(marriages_femme);
            marriage.setEpoux(homme);
            marriage.setEpouse(femme);
            this.personneRepository.save(femme);
            this.personneRepository.save(homme);
            this.marriageRepository.save(marriage);
        }
    }


    public void confirmer(Long id_salle,Long id_marriage){
        Optional<Salle> salleOptional = this.salleRepository.findById(id_salle);
        Optional<Marriage> marriageOptional = this.marriageRepository.findById(id_marriage);
        if(salleOptional.isPresent() && marriageOptional.isPresent()){
            Salle salle = salleOptional.get();
            Marriage marriage = marriageOptional.get();
            List<Marriage> marriages = salle.getMarriages();
            marriages.add(marriage);
            salle.setMarriages(marriages);
            marriage.setSalle(salle);
            this.marriageRepository.save(marriage);
            this.salleRepository.save(salle);
        }
    }
}
