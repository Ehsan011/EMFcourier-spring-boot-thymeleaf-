package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.ParcelDetails;

import org.idb.emf.EMFCourier.entity.RecipientDetails;
import org.idb.emf.EMFCourier.entity.SenderDetails;
import org.idb.emf.EMFCourier.repository.SenderDetailsRepository;
import org.idb.emf.EMFCourier.service.EmailSenderService;
import org.idb.emf.EMFCourier.service.ParcelDetailsService;
import org.idb.emf.EMFCourier.service.RecipientDetailsService;
import org.idb.emf.EMFCourier.service.SenderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParcelDetailsController {

   @Autowired
   private ParcelDetailsService parcelDetailsService;

    @Autowired
    private SenderDetailsService senderDetailsService;

    @Autowired
    SenderDetailsRepository senderDetailsRepository;

    @Autowired
    private RecipientDetailsService recipientDetailsService;

    public int sId=0;

    @Autowired
    EmailSenderService emailSenderService;

   @RequestMapping("/all_parcelDetails/{sender_id}/{recipent_id}/{precel_id}")
   public String allParcel(
           @PathVariable(value = "sender_id") int senderId,
           @PathVariable(value = "recipent_id") int recipentId,
           @PathVariable(value = "precel_id") int precelId,
           Model m){
       sId=senderId;
       SenderDetails sd = senderDetailsService.findSenderDetailsById(senderId);
       RecipientDetails rd = recipientDetailsService.findRecipientDetailsById(recipentId);
       ParcelDetails pd = parcelDetailsService.findParcelDetailsById(precelId);
       m.addAttribute("sd",sd);
       m.addAttribute("rd",rd);
       m.addAttribute("pd",pd);
       return "all_parcelDetails";
   }

    //this is for get a sender registration form
    @RequestMapping("/p_reg_form/{send_id}/{rec_id}")
    public String parcelAddForm(
            @PathVariable(value = "send_id") int senderId,
            @PathVariable(value = "rec_id") int recId,
            Model m){

        ParcelDetails pd = new ParcelDetails();
        pd.setSenderId(senderId);
        pd.setRecipientId(recId);
        m.addAttribute("parcelDetails", pd);
        m.addAttribute("title", "ParcelDetails Registration");
        return "parcel_reg_form";
    }

    //this is for save new student and get all sender list
    @RequestMapping(value = "/add_parcel", method = RequestMethod.POST)
    public String addNewParcel(@ModelAttribute("parcelDetails") ParcelDetails s, Model m ){
        ParcelDetails pd = parcelDetailsService.saveParcelDetails(s);



        SenderDetails senderDetails= senderDetailsRepository.findById(pd.getSenderId()).get();


        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(senderDetails.getEmail());
        message.setSubject("Confirm Registration");
        message.setFrom("info@emranhss.com");
        message.setText("Dear "+senderDetails.getSenderName());
        message.setText("To confirm your account, please click here :"+
                ""+s.getParcelTrakingNumber());
        emailSenderService.sendEmail(message);



        return "redirect:/all_parcelDetails/"+pd.getSenderId()+"/"+pd.getRecipientId()+
                "/"+pd.getId();
    }

    //this is for delete a student by id and get all sender list
    @RequestMapping("/delete_parcel/{id}")
    public String deleteParcel(@PathVariable("id") Integer id){
        parcelDetailsService.deleteParcelDetails(id);
        return "redirect:/all_parcelDetails";
    }

    @RequestMapping(value = "/update_parcel", method = RequestMethod.POST)
    public String parcelUpdateForm(@ModelAttribute("parcelDetails") ParcelDetails s, Model m){
       try {
           ParcelDetails pd = parcelDetailsService.findParcelDetailsById(s.getId());
//           return "redirect:/all_senderDetails";
        return "redirect:/all_parcelDetails/"+s.getSenderId()+"/"+s.getRecipientId()+
              "/"+s.getId();
       }
       catch (Exception e){
           m.addAttribute("parcelDetails", s);
           e.printStackTrace();
       }

       m.addAttribute("parcelDetails", s);
       m.addAttribute("senderId", s.getSenderId());
       m.addAttribute("recpId", s.getRecipientId());
       m.addAttribute("perId", s.getId());

        return "/parcel_reg_form";
    }


//    @RequestMapping("/update_sender/{id}")
//    public String senderUpdateForm(@PathVariable("id") Integer id, Model m){
//        System.out.println(id+"#################################");
//        SenderDetails s = senderDetailsService.findSenderDetailsById(id);
//        System.out.println(id+"#################################");
//        m.addAttribute("senderDetails", s);
//        return "/sender_reg_form";
//    }


    @RequestMapping("/edit_parcel/{sender_id}/{recp_id}/{per_id}")
    public String parcelUpdateForm(
            @PathVariable("sender_id") Integer senderId,
            @PathVariable("recp_id") Integer recpId,
            @PathVariable("per_id") Integer perId,
            Model m){
       ParcelDetails s=parcelDetailsService.findParcelDetailsById(perId);

        m.addAttribute("parcelDetails", s);
        m.addAttribute("senderId", senderId);
        m.addAttribute("recpId", recpId);
        m.addAttribute("perId", perId);
        return "/parcel_reg_form";
    }




}
