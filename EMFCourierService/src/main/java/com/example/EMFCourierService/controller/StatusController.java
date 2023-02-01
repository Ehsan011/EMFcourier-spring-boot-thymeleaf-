package com.example.EMFCourierService.controller;

import com.example.EMFCourierService.entity.Status;

import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/status/getall")
    public List<Status> getAllStatus(){
        return statusRepository.findAll();
    }
    @PostMapping("/status/save")
    public Status save(@RequestBody Status status){
        return statusRepository.save(status);
    }

    @GetMapping("/status/{id}")
    public Status getOne(@PathVariable(value = "id") int id) {

        return statusRepository.findById(id).get();
    }
    @GetMapping("/status/delete/{id}")
    public void delete(@PathVariable(value = "id") int id){
        try {
        statusRepository.deleteById(id);
        }
        catch (Exception e){
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }




}
