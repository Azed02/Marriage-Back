package com.example.marriage.repository;

import com.example.marriage.entity.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteRepository extends JpaRepository<Invite,String> {
}
