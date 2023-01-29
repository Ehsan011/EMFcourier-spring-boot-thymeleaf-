package com.example.EMFCourierService.repository;

import com.example.EMFCourierService.entity.CorporateBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateBookingRepository extends JpaRepository<CorporateBooking,Integer> {
}
