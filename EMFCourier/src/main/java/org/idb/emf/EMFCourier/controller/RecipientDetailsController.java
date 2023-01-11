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



    //this is for get all recipient list
    @RequestMapping("/all_recipientDetails")
    public String allRecipient(Model m){
        m.addAttribute("stdList",service.getAllRecipientDetails());
        return "all_recipientDetails";
    }

    //this is for get a recipient registration form
    @RequestMapping("/r_reg_form/{send_id}")
    public String recipientAddForm(
            @PathVariable(value = "send_id") int senderId,
            Model m){
        RecipientDetails rd = new RecipientDetails();
        rd.setSenderId(senderId);
        m.addAttribute("recipientDetails", rd);
        m.addAttribute("title", "RecipientDetails Registration");
        return "recipient_reg_form";
    }

    //this is for save new recipient and get all recipient list
    @RequestMapping(value = "/add_recipient", method = RequestMethod.POST)
    public String addNewRecipient(
            @ModelAttribute("recipientDetails") RecipientDetails s,
            Model m ){
        try {
            RecipientDetails rd = service.saveRecipientDetails(s);
//        return "redirect:/all_senderDetails";
            return "redirect:/p_reg_form/"+rd.getSenderId()+"/"+rd.getId();
        }catch (Exception e){
            m.addAttribute("sd", s);
            e.printStackTrace();
        }
        return "parcel_reg_form";
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
        m.addAttribute("recipientDetails", s);
        return "/recipient_reg_form";
    }


}
