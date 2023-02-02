package com.example.EMFproject.repository;


import com.example.EMFproject.entity.CoustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoustomerDetailsRepo extends JpaRepository<CoustomerDetails, Integer> {
}
