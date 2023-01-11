package org.idb.emf.EMFCourier.service;

import org.idb.emf.EMFCourier.entity.RecipientDetails;

import org.idb.emf.EMFCourier.repository.RecipientDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipientDetailsService {


        @Autowired
        private RecipientDetailsRepository repo;

        //this method for save recipientDetails
        public RecipientDetails saveRecipientDetails(RecipientDetails s) {
            return repo.save(s);
        }

        //this method for delete a recipientDetails
        public void deleteRecipientDetails(int id) {
            repo.deleteById(id);
        }

        //this method for get all recipientDetails list
        public List<RecipientDetails> getAllRecipientDetails() {
            return repo.findAll();
        }

        //this method for get recipientDetails by id
        public RecipientDetails findRecipientDetailsById(int id) {
            return repo.findById(id).get();
        }


    }
