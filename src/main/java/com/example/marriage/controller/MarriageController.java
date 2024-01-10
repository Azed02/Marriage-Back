package com.example.marriage.controller;

import com.example.marriage.entity.Marriage;
import com.example.marriage.repository.MarriageRepository;
import com.example.marriage.service.MarriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marriage")
public class MarriageController {
    @Autowired
    MarriageService marriageService;

    @GetMapping("/")
    public List<Marriage> getAllMariages(){
        return this.marriageService.getAllMariages();
    }


    @GetMapping("/{id}")
    public Marriage getMarriage(@PathVariable Long id){
        return this.marriageService.getMarriage(id);
    }

    @PostMapping
    public Marriage saveMarriage(@RequestBody Marriage marriage){
        return this.marriageService.saveMarriage(marriage);
    }

    @DeleteMapping("/{id}")
    public void deleteMarriage(@PathVariable Long id){
        this.marriageService.deleteMarriage(id);
    }

    @PostMapping("/{id_marriage}/inv/{id_inv}")
    public void inviter(@PathVariable Long id_marriage,@PathVariable String id_inv){
        this.marriageService.inviter(id_inv,id_marriage);
    }
}