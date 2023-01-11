package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.Department;
import org.idb.emf.EMFCourier.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {


    @Autowired
    DepartmentService depService;
    @RequestMapping("/departments")
    public  String allDep(Model m){
//        List<Department> listDep=service.getAllDep();
        m.addAttribute("viewDep", depService.getAllDep());// Show All Department as a Table
        m.addAttribute("dep", new Department()); // Show save form for Department
        return  "dep_list";
    }

    @RequestMapping(value = "/dep_save", method = RequestMethod.POST)
    public  String addDep(@ModelAttribute("dep") Department dep){
        depService.saveDep(dep);
        return  "redirect:/departments";
    }
}
