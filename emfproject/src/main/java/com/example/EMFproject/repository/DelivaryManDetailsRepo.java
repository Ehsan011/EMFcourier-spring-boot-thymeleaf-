package com.example.EMFproject.repository;


import com.example.EMFproject.entity.DelivaryManDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DelivaryManDetailsRepo extends JpaRepository<DelivaryManDetails, Integer> {
    @Query("select dlm from DelivaryManDetails dlm where dlm.heroStatus=1 and dlm.heroLocation=?1")
    public List<DelivaryManDetails> getDelivaryMan(String location);

}

//  @Query("select dvm from DelivaryManDetails dvm where dvm.dv_ava_st = 1 and dvm.dv_location = ?1")
//    public List<DelivaryManDetails> getDeliMan(String loca);