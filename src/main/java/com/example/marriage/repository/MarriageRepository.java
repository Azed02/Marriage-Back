package com.example.marriage.repository;

import com.example.marriage.entity.Marriage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarriageRepository extends JpaRepository<Marriage,Long> {
}
