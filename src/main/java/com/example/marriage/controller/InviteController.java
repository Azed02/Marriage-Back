package com.example.marriage.controller;

import com.example.marriage.entity.Invite;
import com.example.marriage.repository.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invite")
public class InviteController {
    @Autowired
    InviteRepository inviteRepository;

    @GetMapping("/")
    public List<Invite> getAllInvite(){
        return this.inviteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Invite getInvite(@PathVariable String id){
        return this.inviteRepository.findById(id).get();
    }

    @PostMapping("/add")
    public Invite addInvite(@RequestBody Invite invite){
        return  this.inviteRepository.save(invite);
    }

    @DeleteMapping("/{id}")
    public void deleteInvite(@PathVariable String id){
        this.inviteRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Invite updateInvite(@PathVariable String id,@RequestBody Invite invite){
   Optional<Invite> inviteOptional = this.inviteRepository.findById(id);
        if(inviteOptional.isPresent()){
            Invite inviteAn = inviteOptional.get();
            invite = inviteAn;
        }
        return invite;
    }
}
