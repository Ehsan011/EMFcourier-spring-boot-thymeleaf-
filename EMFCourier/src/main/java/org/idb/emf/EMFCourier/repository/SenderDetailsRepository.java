package org.idb.emf.EMFCourier.repository;

import org.idb.emf.EMFCourier.entity.ParcelDetails;
import org.idb.emf.EMFCourier.entity.SenderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderDetailsRepository extends JpaRepository<SenderDetails ,Integer> {

    @Query("select u from SenderDetails u where u.email=?1") // HSQL = Hibernate Structure Query Language
    SenderDetails findByEmail(String email); // get one row by email
}
