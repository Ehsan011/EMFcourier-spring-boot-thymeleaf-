package com.example.EMFCourierService.controller;

import com.example.EMFCourierService.entity.Booking;

import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/driver/getall")
    public List<Booking> getAllDriver() {

        return bookingRepository.findAll();

    }

    @PostMapping("/driver/save")
    public Booking save(@RequestBody Booking driver) {
        //System.out.print(senserDetails)
        return bookingRepository.save(driver);
//     return new SenderDetails();
    }

    @GetMapping("/driver/{id}")
    public Booking getOne(@PathVariable(value = "id") int id) {

        return bookingRepository.findById(id).get();
    }

    @GetMapping("/driver/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            bookingRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}

