package com.example.EMFCourierService.repository;

import com.example.EMFCourierService.entity.DelivaryInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelivaryInventoryRepo extends JpaRepository<DelivaryInventory, Integer> {

}

//@Query("update DelivaryInventory di set di.x_order_staus = 3 where di.x_id = ?1")
//    public void updateInven(int id);