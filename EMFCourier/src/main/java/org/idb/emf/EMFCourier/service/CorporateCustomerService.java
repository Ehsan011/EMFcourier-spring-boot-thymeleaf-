package org.idb.emf.EMFCourier.service;

import org.idb.emf.EMFCourier.entity.CorporateCustomer;
import org.idb.emf.EMFCourier.repository.CorporateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateCustomerService {

    @Autowired
    CorporateCustomerRepository repo;

    public CorporateCustomer saveCC(CorporateCustomer cc){
        repo.save(cc);
        return cc;
    }

    public void deleteCC(int ccId){

        repo.deleteById(ccId);
    }

    public List<CorporateCustomer> getAllCC(){

        return repo.findAll();
    }

    public CorporateCustomer findCCById(int ccId){

        return repo.findById(ccId).get();
    }
}
