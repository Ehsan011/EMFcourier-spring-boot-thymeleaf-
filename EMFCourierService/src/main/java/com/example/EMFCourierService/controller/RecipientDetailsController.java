package com.example.EMFCourierService.controller;

import com.example.EMFCourierService.entity.RecipientDetails;

import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.RecipientDetailsRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class RecipientDetailsController {@Autowired
private RecipientDetailsRepository recipientDetailsRepository;

    @GetMapping("/recipient/getall")
    public List<RecipientDetails> getAllRecipient() {

        return recipientDetailsRepository.findAll();

    }

    @PostMapping("/recipient/save")
    public RecipientDetails save(@RequestBody RecipientDetails recipientDetails) {

        return recipientDetailsRepository.save(recipientDetails);
//        return new SenserDetails();
    }

    @GetMapping("/recipient/{id}")
    public RecipientDetails getOne(@PathVariable(value = "id") int id) {

        return recipientDetailsRepository.findById(id).get();
    }

    @GetMapping("/recipient/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            recipientDetailsRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}
