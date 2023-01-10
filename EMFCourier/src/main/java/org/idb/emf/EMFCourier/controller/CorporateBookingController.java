package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.CorporateBooking;
import org.idb.emf.EMFCourier.service.CorporateBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CorporateBookingController {
    @Autowired
    CorporateBookingService service;

    @RequestMapping("/cb_list")
    public String allCoBooking(Model m) {
        List<CorporateBooking> cbList = service.getAllCB();
        m.addAttribute("cblist", cbList);
        m.addAttribute("title", "All Corporate Booking");
        return "cb_list";
    }

    @RequestMapping("/cb_save_form")
    public String cbSaveForm(Model m) {
        m.addAttribute("corporates", new CorporateBooking());
        m.addAttribute("title", "Add Corporate Customar");
        return "cb_save_form";
    }

    @RequestMapping(value = "/cb_save", method = RequestMethod.POST)
    public String cbOrderSave(@ModelAttribute("cb") CorporateBooking cb, Model m) {
        service.saveCb(cb);
        return "redirect:/cb_list";
    }

    @RequestMapping("/cb_delete/{cbId}")
    public String cbDelete(@PathVariable("cbId") Integer cbId) {
        service.deleteCB(cbId);
        return "redirect:/cb_list";
    }

    @RequestMapping("/cb_edit/{ccId}")
    public String cbEditForm(@PathVariable("ccId") Integer cbId, Model m) {
        CorporateBooking cblist = service.findCBById(cbId);
        m.addAttribute("cblist", cblist);
        return "cb_save_form";
    }
}
