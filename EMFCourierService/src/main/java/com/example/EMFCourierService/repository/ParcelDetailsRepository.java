package com.example.EMFCourierService.repository;

import com.example.EMFCourierService.entity.ParcelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ParcelDetailsRepository extends JpaRepository<ParcelDetails, Integer> {
}
