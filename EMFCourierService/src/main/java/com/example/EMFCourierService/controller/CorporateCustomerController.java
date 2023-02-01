package com.example.EMFCourierService.controller;


import com.example.EMFCourierService.entity.CorporateCustomer;
import com.example.EMFCourierService.exceptions.ResourceNotFoundException;

import com.example.EMFCourierService.repository.CorporateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/corporate")
public class CorporateCustomerController {
    @Autowired
    private CorporateCustomerRepository corporateCustomerRepository;

    @GetMapping("/coustomer/getall")
    public List<CorporateCustomer> getAllCoustomer() {

        return corporateCustomerRepository.findAll();

    }

    @PostMapping("/coustomer/save")
    public CorporateCustomer save(@RequestBody CorporateCustomer corporateCustomer) {

        return corporateCustomerRepository.save(corporateCustomer);
    }

    @GetMapping("/coustomer/{id}")
    public CorporateCustomer getOne(@PathVariable(value = "id") int id) {

        return corporateCustomerRepository.findById(id).get();
    }

    @GetMapping("/coustomer/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            corporateCustomerRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}