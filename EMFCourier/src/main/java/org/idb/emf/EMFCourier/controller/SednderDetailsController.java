package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.SenderDetails;
import org.idb.emf.EMFCourier.service.SenderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SednderDetailsController {
    @Autowired
    private SenderDetailsService service;

    //this is for index/home page
    @RequestMapping("/")
    public String home(){
        return "index";
    }

    //this is for get all student list
    @RequestMapping("/all_senderDetails")
    public String allStudent(Model m){
        m.addAttribute("stdList",service.getAllSenderDetails());
        return "all_senderDetails";
    }

    //this is for get a student registration form
    @RequestMapping("/s_reg_form")
    public String senderAddForm(Model m){
        m.addAttribute("senderDetails", new SenderDetails());
        m.addAttribute("title", "SenderDetails Registration");
        return "sender_reg_form";
    }

    //this is for save new student and get all student list
    @RequestMapping(value = "/add_sender", method = RequestMethod.POST)
    public String addNewStudent(@ModelAttribute("student") SenderDetails s, Model m ){
        service.saveSenderDetails(s);
        return "redirect:/all_senderDetails";
    }

    //this is for delete a student by id and get all student list
    @RequestMapping("/delete_student/{id}")
    public String deleteSender(@PathVariable("id") Integer id){
        service.deleteSenderDetails(id);
        return "redirect:/all_senderDetails";
    }
    @RequestMapping("/update_sender/{id}")
    public String studentUpdateForm(@PathVariable("id") Integer id, Model m){
        SenderDetails s = service.findSenderDetailsById(id);
        m.addAttribute("sender", s);
        return "/sender_reg_form";
    }


}
