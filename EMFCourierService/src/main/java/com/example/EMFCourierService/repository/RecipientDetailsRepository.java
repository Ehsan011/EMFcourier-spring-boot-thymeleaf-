package com.example.EMFCourierService.repository;

import com.example.EMFCourierService.entity.RecipientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RecipientDetailsRepository extends JpaRepository<RecipientDetails,Integer> {
}
