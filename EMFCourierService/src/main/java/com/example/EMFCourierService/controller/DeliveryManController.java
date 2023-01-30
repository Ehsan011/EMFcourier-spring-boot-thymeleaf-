package com.example.EMFCourierService.controller;
import com.example.EMFCourierService.entity.Delivery_man;
import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.DeliveryManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/deliveryman")
public class DeliveryManController {

    @Autowired
    DeliveryManRepository deliveryManRepository;

    @GetMapping("/getall")
    public List<Delivery_man> getAllHero(){
        return deliveryManRepository.findAll();
    }

    @PostMapping("/savehero")
    public Delivery_man addHero(@RequestBody Delivery_man delivery_man){
        return deliveryManRepository.save(delivery_man);
    }

    @GetMapping("/edit/{heroId}")
    public Delivery_man getEdit(@PathVariable(value = "heroId") Integer heroId){
        return deliveryManRepository.findById(heroId).get();
    }

    @GetMapping("/delete/{heroId}")
    public void delete(@PathVariable(value = "heroId") int heroId) {
        try {
            deliveryManRepository.deleteById(heroId);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }

}
