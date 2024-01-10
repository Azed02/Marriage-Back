package com.example.marriage.controller;


import com.example.marriage.entity.Salle;
import com.example.marriage.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salle")
public class SalleController {
    @Autowired
    SalleRepository salleRepository;

    @GetMapping("/")
    public List<Salle> getAllSalle(){
        return this.salleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Salle getSalle(@PathVariable Long id){
        return this.salleRepository.findById(id).get();
    }

    @PostMapping
    public Salle saveSalle(@RequestBody Salle salle){
        return  this.salleRepository.save(salle);
    }

    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable Long id){
        this.salleRepository.deleteById(id);
    }
}
