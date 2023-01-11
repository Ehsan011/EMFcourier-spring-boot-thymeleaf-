package org.idb.emf.EMFCourier.service;

import org.idb.emf.EMFCourier.entity.ParcelDetails;

import org.idb.emf.EMFCourier.repository.ParcelDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParcelDetailsService {

    @Autowired
    private ParcelDetailsRepository repo;

    //this method for save sednderDetails
    public ParcelDetails saveParcelDetails(ParcelDetails s){
        return repo.save(s);
    }

    //this method for delete a sednderDetails
    public void deleteParcelDetails(int id){
        repo.deleteById(id);
    }

    //this method for get all sednderDetails list
    public List<ParcelDetails> getAllParcelDetails(){
        return repo.findAll();
    }

    //this method for get sednderDetails by id
    public ParcelDetails findParcelDetailsById(int id){
        return repo.findById(id).get();
    }
}

