package com.example.EMFCourierService.controller;
import com.example.EMFCourierService.entity.SenderDetails;
import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.SenderDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class SenderDetailsController {


    @Autowired
    private SenderDetailsRepository senserDetailsRepository;

    @GetMapping("/sender/getall")
    public List<SenderDetails> getAllSender() {

        return senserDetailsRepository.findAll();

    }

    @PostMapping("/sender/save")
    public SenderDetails save(@RequestBody SenderDetails senserDetails) {

//        return senserDetailsRepository.save(senserDetails);
     return new SenderDetails();
    }

    @GetMapping("/sender/{id}")
    public SenderDetails getOne(@PathVariable(value = "id") int id) {

        return senserDetailsRepository.findById(id).get();
    }

    @GetMapping("/sender/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            senserDetailsRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}
