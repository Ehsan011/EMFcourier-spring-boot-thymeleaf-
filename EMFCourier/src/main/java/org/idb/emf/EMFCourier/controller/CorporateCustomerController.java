package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.CorporateCustomer;
import org.idb.emf.EMFCourier.service.CorporateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CorporateCustomerController {

    @Autowired
    CorporateCustomerService service;


    @RequestMapping(value = {"", "/index", "/home"})
    public String home() {

        return "index";
    }

    @RequestMapping("/cc_list")
    public String allEmp(Model m) {
        List<CorporateCustomer> ccList = service.getAllCC();
        m.addAttribute("cclist", ccList);
        m.addAttribute("title", "All Corporate Customar");
        return "cc_list";
    }

    @RequestMapping("/cc_save_form")
    public String ccSaveForm(Model m) {
        m.addAttribute("corporate", new CorporateCustomer());
        m.addAttribute("title", "Add Corporate Customar");
        return "cc_save_form";
    }

    @RequestMapping(value = "/cc_save", method = RequestMethod.POST)
    public String empSave(@ModelAttribute("cc") CorporateCustomer cc, Model m) {
        service.saveCC(cc);
        return "redirect:/cc_list";
    }

    @RequestMapping("/cc_delete/{ccId}")
    public String ccDelete(@PathVariable("ccId") Integer ccId) {
        service.deleteCC(ccId);
        return "redirect:/cc_list";
    }

    @RequestMapping("/cc_edit/{ccId}")
    public String empEditForm(@PathVariable("ccId") Integer ccId, Model m) {
        CorporateCustomer cclist = service.findCCById(ccId);
        m.addAttribute("cclist", cclist);
        return "cc_save_form";
    }
}
