package com.example.EMFCourierService.repository;

import com.example.EMFCourierService.entity.ExecutiveOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutiveOfficeRepository extends JpaRepository<ExecutiveOffice, Integer> {
}
