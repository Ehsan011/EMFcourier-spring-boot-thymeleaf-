package org.idb.emf.EMFCourier.repository;

import org.idb.emf.EMFCourier.entity.CorporateToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateTokenRepository extends JpaRepository<CorporateToken, Long> {
    CorporateToken findByConfirmationToken(String token);
}
