package com.example.marriage.service;

import com.example.marriage.entity.Invite;
import com.example.marriage.entity.Marriage;
import com.example.marriage.repository.InviteRepository;
import com.example.marriage.repository.MarriageRepository;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MarriageService {
    @Autowired
    MarriageRepository marriageRepository;

    @Autowired
    InviteRepository inviteRepository;

    public Marriage getMarriage(Long id){
        return this.marriageRepository.findById(id).get();
    }

    public  List<Marriage> getAllMariages(){
        return  this.marriageRepository.findAll();
    }
    public Marriage saveMarriage(Marriage marriage){
        return  this.marriageRepository.save(marriage);
    }
    public void deleteMarriage(Long id){
        this.marriageRepository.deleteById(id);
    }



    public void inviter (String id_invite , Long id_marriage){
        Optional<Invite> inviteOptional = this.inviteRepository.findById(id_invite);
        Optional<Marriage> marriageOptional = this.marriageRepository.findById(id_marriage);
        if(inviteOptional.isPresent()&&marriageOptional.isPresent()){
            Invite invite = inviteOptional.get();
            Marriage marriage = marriageOptional.get();
            List<Marriage> marriages = invite.getMarriages();
            if(marriages==null){
                marriages=new ArrayList<>();
            }
            marriages.add(marriage);
            invite.setMarriages(marriages);
            List<Invite> invites = marriage.getInvites();

            if(invites==null){
                invites=new ArrayList<>();
            }
            invites.add(invite);
            marriage.setInvites(invites);

            this.inviteRepository.save(invite);
            this.marriageRepository.save(marriage);
        }
    }
}
