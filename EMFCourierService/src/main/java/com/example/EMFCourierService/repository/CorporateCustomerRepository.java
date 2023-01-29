package com.example.EMFCourierService.repository;

import com.example.EMFCourierService.entity.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer,Integer> {
}
