package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.RecipientDetails;
import org.idb.emf.EMFCourier.entity.SenderDetails;
import org.idb.emf.EMFCourier.service.RecipientDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/update_recipient", method = RequestMethod.POST)
    public String updateRecipient(
            @ModelAttribute("recipientDetails") RecipientDetails s,
            @RequestParam(value = "perId") int perId,
            Model m ){
        try {
            RecipientDetails rd = service.saveRecipientDetails(s);
//        return "redirect:/all_senderDetails";
            return "redirect:/all_parcelDetails/"+s.getSenderId()+"/"+s.getId()+
                    "/"+perId;
        }catch (Exception e){
            m.addAttribute("recipientDetails", s);
            e.printStackTrace();
        }

        m.addAttribute("recipientDetails", s);
        m.addAttribute("senderId", s.getSenderId());
        m.addAttribute("recpId", s.getId());
        m.addAttribute("perId", perId);
        return "parcel_reg_form";
    }

    //this is for delete a student by id and get all sender list
    @RequestMapping("/delete_recipient/{id}")
    public String deleteRecipient(@PathVariable("id") Integer id){
        service.deleteRecipientDetails(id);
        return "redirect:/all_recipientDetails";
    }
    @RequestMapping("/edit_recipient/{sender_id}/{recp_id}/{per_id}")
    public String recipientUpdateForm(
            @PathVariable("sender_id") Integer senderId,
            @PathVariable("recp_id") Integer recpId,
            @PathVariable("per_id") Integer perId,
            Model m){
        RecipientDetails s = service.findRecipientDetailsById(recpId);
        m.addAttribute("recipientDetails", s);
        m.addAttribute("senderId", senderId);
        m.addAttribute("recpId", recpId);
        m.addAttribute("perId", perId);
        return "/recipient_reg_form";
    }


}
