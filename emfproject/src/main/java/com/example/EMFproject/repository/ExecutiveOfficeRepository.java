package com.example.EMFproject.repository;

import com.example.EMFproject.entity.ExecutiveOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutiveOfficeRepository extends JpaRepository<ExecutiveOffice, Integer> {
}
