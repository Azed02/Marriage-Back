package com.example.marriage.repository;

import com.example.marriage.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
