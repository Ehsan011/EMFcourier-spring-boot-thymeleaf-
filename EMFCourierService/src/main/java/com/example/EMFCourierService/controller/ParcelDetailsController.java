package com.example.EMFCourierService.controller;
import com.example.EMFCourierService.entity.ParcelDetails;
import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.ParcelDetailsRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class ParcelDetailsController { @Autowired
private ParcelDetailsRepository parcelDetailsRepository;

    @GetMapping("/parcel/getall")
    public List<ParcelDetails> getAllParcel() {

        return parcelDetailsRepository.findAll();

    }

    @PostMapping("/parcel/save")
    public ParcelDetails save(@RequestBody ParcelDetails parcelDetails) {

        return parcelDetailsRepository.save(parcelDetails);
//        return new SenserDetails();
    }

    @GetMapping("/parcel/{id}")
    public ParcelDetails getOne(@PathVariable(value = "id") int id) {

        return parcelDetailsRepository.findById(id).get();
    }

    @GetMapping("/parcel/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            parcelDetailsRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}