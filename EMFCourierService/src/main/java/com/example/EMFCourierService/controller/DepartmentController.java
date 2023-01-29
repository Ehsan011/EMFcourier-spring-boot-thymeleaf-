package com.example.EMFCourierService.controller;


import com.example.EMFCourierService.entity.Department;
import com.example.EMFCourierService.exceptions.ResourceNotFoundException;
import com.example.EMFCourierService.repository.DepartmentRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class DepartmentController {
	
	@Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/department/getall")
    public List<Department> getAllSender() {

        return departmentRepository.findAll();

    }

    @PostMapping("/department/save")
    public Department save(@RequestBody Department department) {

        return departmentRepository.save(department);
//        return new SenserDetails();
    }

    @GetMapping("/department/{id}")
    public Department getOne(@PathVariable(value = "id") int id) {

        return departmentRepository.findById(id).get();
    }

    @GetMapping("/department/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {

        try {
        	departmentRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No found data by this Id");
        }
    }
}
