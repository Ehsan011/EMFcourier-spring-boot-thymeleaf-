package com.example.EMFCourierService.controller;

import com.example.EMFCourierService.entity.Employee;
import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class EmployeeController {
    @Autowired
private EmployeeRepository employeeRepository;

    @GetMapping("/employee/getall")
    public List<Employee> getAllEmployee() {

        return employeeRepository.findAll();

    }

    @PostMapping("/employee/save")
    public Employee save(@RequestBody Employee employee) {

        return employeeRepository.save(employee);
//        return new SenserDetails();
    }

    @GetMapping("/employee/{id}")
    public Employee getOne(@PathVariable(value = "id") int id) {

        return employeeRepository.findById(id).get();
    }

    @GetMapping("/employee/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}