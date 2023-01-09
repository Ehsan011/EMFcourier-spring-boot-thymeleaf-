package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.RecipientDetails;
import org.idb.emf.EMFCourier.entity.SenderDetails;
import org.idb.emf.EMFCourier.service.RecipientDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipientDetailsController {
    @Autowired
    private RecipientDetailsService service;

//    //this is for index/home page
//    @RequestMapping("/")
//    public String home(){
//        return "index";
//    }

    //this is for get all recipient list
    @RequestMapping("/all_recipientDetails")
    public String allRecipient(Model m){
        m.addAttribute("stdList",service.getAllRecipientDetails());
        return "all_recipientDetails";
    }

    //this is for get a recipient registration form
    @RequestMapping("/r_reg_form")
    public String recipientAddForm(Model m){
        m.addAttribute("recipientDetails", new RecipientDetails());
        m.addAttribute("title", "RecipientDetails Registration");
        return "recipient_reg_form";
    }

    //this is for save new recipient and get all recipient list
    @RequestMapping(value = "/add_recipient", method = RequestMethod.POST)
    public String addNewRecipient(@ModelAttribute("recipient") RecipientDetails s, Model m ){
        service.saveRecipientDetails(s);
        return "redirect:/all_recipientDetails";
    }

    //this is for delete a student by id and get all sender list
    @RequestMapping("/delete_recipient/{id}")
    public String deleteRecipient(@PathVariable("id") Integer id){
        service.deleteRecipientDetails(id);
        return "redirect:/all_recipientDetails";
    }
    @RequestMapping("/update_recipient/{id}")
    public String recipientUpdateForm(@PathVariable("id") Integer id, Model m){
        RecipientDetails s = service.findRecipientDetailsById(id);
        m.addAttribute("recipient", s);
        return "/recipient_reg_form";
    }


}
