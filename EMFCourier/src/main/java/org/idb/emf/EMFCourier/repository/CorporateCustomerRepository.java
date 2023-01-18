package org.idb.emf.EMFCourier.repository;

import org.idb.emf.EMFCourier.entity.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {

//    @Query("select u from CorporateCustomer u where u.ccEmail=?1") // HSQL = Hibernate Structure Query Language
    CorporateCustomer findByccEmail(String email); // get one row by email


}
