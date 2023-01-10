package org.idb.emf.EMFCourier.service;

import org.idb.emf.EMFCourier.entity.CorporateBooking;
import org.idb.emf.EMFCourier.entity.CorporateCustomer;
import org.idb.emf.EMFCourier.repository.CorporateBookingRepository;
import org.idb.emf.EMFCourier.repository.CorporateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateBookingService {
    @Autowired
    CorporateBookingRepository repo;

    public void saveCb(CorporateBooking cb){
        repo.save(cb);
    }

    public void deleteCB(int ccId){
        repo.deleteById(ccId);
    }

    public List<CorporateBooking> getAllCB(){
        return repo.findAll();
    }

    public CorporateBooking findCBById(int cbId){
        return repo.findById(cbId).get();
    }
}
