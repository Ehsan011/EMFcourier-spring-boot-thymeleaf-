package com.example.EMFCourierService.controller;
import com.example.EMFCourierService.entity.Delivery_man;

import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.DeliveryManRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})

public class DeliveryManController {

    @Autowired
    private DeliveryManRepository deliveryManRepository;

    @GetMapping("/delivary/getall")
    public List<Delivery_man> getAllDelivary() {

        return deliveryManRepository.findAll();

    }

    @PostMapping("/delivary/save")
    public Delivery_man save(@RequestBody Delivery_man delivery_man) {
        //System.out.print(senserDetails)
        return deliveryManRepository.save(delivery_man);
//     return new SenderDetails();
    }

    @GetMapping("/delivary/{id}")
    public Delivery_man getOne(@PathVariable(value = "id") int id) {

        return deliveryManRepository.findById(id).get();
    }

    @GetMapping("/delivary/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            deliveryManRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}