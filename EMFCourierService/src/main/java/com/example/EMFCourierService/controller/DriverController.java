package com.example.EMFCourierService.controller;

import com.example.EMFCourierService.entity.Driver;

import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.DriverRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/driver/getall")
    public List<Driver> getAllDriver() {

        return driverRepository.findAll();

    }

    @PostMapping("/driver/save")
    public Driver save(@RequestBody Driver driver) {
        //System.out.print(senserDetails)
        return driverRepository.save(driver);
//     return new SenderDetails();
    }

    @GetMapping("/driver/{id}")
    public Driver getOne(@PathVariable(value = "id") int id) {

        return driverRepository.findById(id).get();
    }

    @GetMapping("/driver/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            driverRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}

