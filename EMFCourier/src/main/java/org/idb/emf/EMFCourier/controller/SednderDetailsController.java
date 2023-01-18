package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.SenderDetails;
import org.idb.emf.EMFCourier.service.SenderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SednderDetailsController {
    @Autowired
    private SenderDetailsService service;

//    //this is for index/home page
//    @RequestMapping("/")
//    public String home(){
//        return "index";
//    }

    //this is for get all sender list
    @RequestMapping("/all_senderDetails")
    public String allSender(Model m){
        m.addAttribute("stdList",service.getAllSenderDetails());
        return "all_senderDetails";
    }


    @RequestMapping(value = {"/profile"})
    public String profile() {

        return "profile";
    }

    //this is for get a sender registration form
    @RequestMapping("/s_reg_form")
    public String senderAddForm(Model m){
        m.addAttribute("senderDetails", new SenderDetails());
        m.addAttribute("title", "SenderDetails Registration");
        return "sender_reg_form";
    }

    //this is for save new student and get all sender list
    @RequestMapping(value = "/add_sender", method = RequestMethod.POST)
    public String addNewSender(
            @ModelAttribute("senderDetails") SenderDetails s,
            Model m ){
       try {
           BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

           s.setPassword(encoder.encode(s.getPassword()));
           s.setEnabled(true);
           s.setRole("USER");

           SenderDetails sd = service.saveSenderDetails(s);
//        return "redirect:/all_senderDetails";
           return "redirect:/r_reg_form/"+sd.getId();
       }catch (Exception e){
            m.addAttribute("sd", s);
            e.printStackTrace();
       }
        return "sender_reg_form";
    }

    @RequestMapping(value = "/update_sender", method = RequestMethod.POST)
    public String senderUpdate(
            @ModelAttribute("senderDetails") SenderDetails s,
            @RequestParam(value = "recpId") int recpId,
            @RequestParam(value = "perId") int perId,
            Model m ){
        try {
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

            s.setPassword(encoder.encode(s.getPassword()));
            s.setEnabled(true);
            s.setRole("USER");

            SenderDetails sd = service.saveSenderDetails(s);
//        return "redirect:/all_senderDetails";
            return "redirect:/all_parcelDetails/"+s.getId()+"/"+recpId+
                    "/"+perId;
        }catch (Exception e){
            m.addAttribute("sd", s);
            e.printStackTrace();
        }
        m.addAttribute("senderDetails", s);
        m.addAttribute("senderId", s.getId());
        m.addAttribute("recpId", recpId);
        m.addAttribute("perId", perId);
        return "sender_reg_form";
    }

    //this is for delete a student by id and get all sender list
    @RequestMapping("/delete_sender/{id}")
    public String deleteSender(@PathVariable("id") Integer id){
        service.deleteSenderDetails(id);
        return "redirect:/all_senderDetails";
    }

    @RequestMapping("/edit_sender/{sender_id}/{recp_id}/{per_id}")
    public String senderUpdateForm(
            @PathVariable("sender_id") Integer senderId,
            @PathVariable("recp_id") Integer recpId,
            @PathVariable("per_id") Integer perId
            , Model m){
        SenderDetails s = service.findSenderDetailsById(senderId);
        m.addAttribute("senderDetails", s);
        m.addAttribute("senderId", senderId);
        m.addAttribute("recpId", recpId);
        m.addAttribute("perId", perId);
        return "/sender_reg_form";
    }





}
