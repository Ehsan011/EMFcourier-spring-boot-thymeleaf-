package com.example.EMFCourierService.controller;
import com.example.EMFCourierService.entity.CorporateBooking;
import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.CorporateBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/corporate")
public class CorporateBookingController {
    @Autowired
    private CorporateBookingRepository corporateBookingRepository;

    @GetMapping("/booking/getall")
    public List<CorporateBooking> getAllBooking() {

        return corporateBookingRepository.findAll();

    }

    @PostMapping("/booking/save")
    public CorporateBooking save(@RequestBody CorporateBooking corporateBooking) {

        return corporateBookingRepository.save(corporateBooking);
//        return new SenserDetails();
    }

    @GetMapping("/booking/{id}")
    public CorporateBooking getOne(@PathVariable(value = "id") int id) {

        return corporateBookingRepository.findById(id).get();
    }

    @GetMapping("/booking/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            corporateBookingRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}