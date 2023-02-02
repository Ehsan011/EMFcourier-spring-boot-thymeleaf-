package com.example.EMFproject.controller;


import com.example.EMFproject.entity.DelivaryInventory;
import com.example.EMFproject.entity.DelivaryManDetails;
import com.example.EMFproject.entity.OrderDetails;
import com.example.EMFproject.repository.DelivaryInventoryRepo;
import com.example.EMFproject.repository.DelivaryManDetailsRepo;
import com.example.EMFproject.repository.OrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RestControllerOrderProcessing {

    @Autowired
    OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private DelivaryManDetailsRepo delivaryManDetailsRepo;
    @Autowired
    private DelivaryInventoryRepo delivaryInventoryRepo;


    @RequestMapping("/get_all_orders")
    public List<OrderDetails> getOders() {
        return orderDetailsRepo.findAll();
    }

    @RequestMapping("/save_oder")
    public void saveOder(@RequestBody OrderDetails or) {
        orderDetailsRepo.save(or);
    }

    @GetMapping("/userd/{id}")
    public OrderDetails getUpdate(@PathVariable(value = "id") int id) {
        return orderDetailsRepo.findById(id).get();
    }

    @GetMapping("/get_available_dlm/{location}")
    public List<DelivaryManDetails> getAvaMan(@PathVariable("location") String lo){
        return delivaryManDetailsRepo.  getDelivaryMan(lo);
    }

    @GetMapping("/get_all_delivary_invantory")
    public List<DelivaryInventory> getDelivayOrder(){
        return delivaryInventoryRepo.findAll();
    }

    @RequestMapping("/add_delivary_invantory_status")
    public void adminAddDelivary(@RequestBody DelivaryInventory dlIn){
        dlIn.setInventory_order_staus(2);
        delivaryInventoryRepo.save(dlIn);
    }






}