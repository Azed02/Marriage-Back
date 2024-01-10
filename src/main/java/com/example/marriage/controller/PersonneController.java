package com.example.marriage.controller;

import com.example.marriage.entity.Marriage;
import com.example.marriage.entity.Personne;
import com.example.marriage.repository.MarriageRepository;
import com.example.marriage.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personne")
public class PersonneController {

    @Autowired
    PersonneService personneService;
    @Autowired
    MarriageRepository marriageRepository;

    @GetMapping("/")
    public List<Personne> getPersonnes(){
        return this.personneService.getAllpersonne();
    }

    @GetMapping("/{id}")
    public Personne getPersonneById(@PathVariable Long id){
        return  this.personneService.getPersonneById(id).get();
    }

    @PostMapping
    public Personne savePersonne(@RequestBody Personne personne){
        return  this.personneService.savePersonne(personne);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        this.personneService.deletePersonneById(id);
    }


    @PostMapping("/{id_epoux}/avec/{id_epouse}")
    public void reserverMarriage(@PathVariable Long id_epoux, @PathVariable Long id_epouse, @RequestBody Marriage marriage){
        this.personneService.reserver(id_epouse,id_epoux,marriage);
    }

    @PostMapping("/{id_marriage}/{id_salle}")
    public void confirmer(@PathVariable Long id_marriage,@PathVariable Long id_salle){
        this.personneService.confirmer(id_salle,id_marriage);
    }


}
