package com.example.EMFCourierService.controller;

import com.example.EMFCourierService.entity.ExecutiveOffice;
import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.ExecutiveOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/executive")
public class ExecutiveOfficeController {

    @Autowired
    ExecutiveOfficeRepository executiveOfficeRepository;

    @GetMapping("/getall")
    public List<ExecutiveOffice> getAllExc(){
        return executiveOfficeRepository.findAll();
    }

    @PostMapping("/saveexc")
    public ExecutiveOffice addHero(@RequestBody ExecutiveOffice executiveOffice){
        return executiveOfficeRepository.save(executiveOffice);
    }

    @GetMapping("/edit/{id}")
    public ExecutiveOffice getEdit(@PathVariable(value = "id") Integer id){
        return executiveOfficeRepository.findById(id).get();
    }

    @GetMapping("/delete/{heroId}")
    public void delete(@PathVariable(value = "id") int id) {
        try {
            executiveOfficeRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}
