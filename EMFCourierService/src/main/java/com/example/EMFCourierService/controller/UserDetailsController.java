package com.example.EMFCourierService.controller;


import com.example.EMFCourierService.entity.UserDetails;
import com.example.EMFCourierService.exceptions.ResourceNotFoundException;

import com.example.EMFCourierService.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class UserDetailsController {


    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @GetMapping("/user/getall")
    public List<UserDetails> getAllUser() {

        return userDetailsRepository.findAll();
    }

    @PostMapping("/user/save")
    public UserDetails save(@RequestBody UserDetails userDetails) {
        //System.out.print(senserDetails)
        return userDetailsRepository.save(userDetails);
//     return new SenderDetails();
    }

    @GetMapping("/user/{id}")
    public UserDetails getOne(@PathVariable(value = "id") int id) {

        return userDetailsRepository.findById(id).get();
    }

    @GetMapping("/user/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            userDetailsRepository.deleteById(id);
        } catch (Exception e) {
                throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}

