package com.example.EMFCourierService.repository;

import com.example.EMFCourierService.entity.Delivery_man;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryManRepository extends JpaRepository<Delivery_man,Integer> {
}
