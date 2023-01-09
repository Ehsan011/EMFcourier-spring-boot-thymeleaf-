package org.idb.emf.EMFCourier.repository;

import org.idb.emf.EMFCourier.entity.SenderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderDetailsRepository extends JpaRepository<SenderDetails ,Integer> {
}
