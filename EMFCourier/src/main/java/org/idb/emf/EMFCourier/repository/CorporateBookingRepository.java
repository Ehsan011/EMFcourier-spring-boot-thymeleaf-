package org.idb.emf.EMFCourier.repository;

import org.idb.emf.EMFCourier.entity.CorporateBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateBookingRepository extends JpaRepository<CorporateBooking, Integer> {
}
