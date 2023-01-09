package org.idb.emf.EMFCourier.repository;

import org.idb.emf.EMFCourier.entity.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {

}
