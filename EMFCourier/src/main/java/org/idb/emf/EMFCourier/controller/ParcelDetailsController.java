package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.ParcelDetails;

import org.idb.emf.EMFCourier.service.ParcelDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParcelDetailsController {

   @Autowired
   private ParcelDetailsService service;

   @RequestMapping("/all_parcelDetails")
   public String allParcel(Model m){
       m.addAttribute("stdList",service.getAllParcelDetails());
       return "all_parcelDetails";
   }

    //this is for get a sender registration form
    @RequestMapping("/p_reg_form")
    public String parcelAddForm(Model m){
        m.addAttribute("parcelDetails", new ParcelDetails());
        m.addAttribute("title", "ParcelDetails Registration");
        return "parcel_reg_form";
    }

    //this is for save new student and get all sender list
    @RequestMapping(value = "/add_parcel", method = RequestMethod.POST)
    public String addNewParcel(@ModelAttribute("parcelDetails") ParcelDetails s, Model m ){
        service.saveParcelDetails(s);
        return "redirect:/all_parcelDetails";
    }

    //this is for delete a student by id and get all sender list
    @RequestMapping("/delete_parcel/{id}")
    public String deleteParcel(@PathVariable("id") Integer id){
        service.deleteParcelDetails(id);
        return "redirect:/all_parcelDetails";
    }
    @RequestMapping("/update_parcel/{id}")
    public String parcelUpdateForm(@PathVariable("id") Integer id, Model m){
        ParcelDetails s = service.findParcelDetailsById(id);
        m.addAttribute("parcelDetails", s);
        return "/parcel_reg_form";
    }


}
