package com.example.EMFCourierService.repository;


import com.example.EMFCourierService.entity.CoustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoustomerDetailsRepo extends JpaRepository<CoustomerDetails, Integer> {
}
