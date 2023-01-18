package org.idb.emf.EMFCourier.controller;

import org.idb.emf.EMFCourier.entity.CorporateCustomer;
import org.idb.emf.EMFCourier.entity.CorporateToken;
import org.idb.emf.EMFCourier.repository.CorporateCustomerRepository;
import org.idb.emf.EMFCourier.repository.CorporateTokenRepository;
import org.idb.emf.EMFCourier.service.CorporateCustomerService;
import org.idb.emf.EMFCourier.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CorporateCustomerController {



    @Autowired
    CorporateCustomerService service;

    long startTime= 0;

    @Autowired
    private CorporateCustomerRepository repo;
    @Autowired
    private final JavaMailSender javaMailSender;
    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    private CorporateTokenRepository tokenRepository;

    public CorporateCustomerController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @RequestMapping(value = {"/", "/index", "/home" })
    public String home() {

        return "index";
    }
    @RequestMapping(value =  "/about")
    public String about() {

        return "about";
    }
    @RequestMapping(value =  "/admin")
    public String admin() {

        return "admin";
    }

    @RequestMapping(value = {"/successful"})
    public String msg() {

        return "successful";
    }

    @RequestMapping(value = { "/login"})
    public String login() {

        return "login";
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
    public String empSave(@ModelAttribute("corporate") CorporateCustomer cc, Model m) {

           long s=System.currentTimeMillis();
           startTime+=s+4000000;

           BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
           cc.setCcPassword(encoder.encode(cc.getCcPassword()));
           CorporateCustomer ccm= service.saveCC(cc);

           //  Send validation Email
           CorporateToken confirmationToken = new CorporateToken(cc);
           tokenRepository.save(confirmationToken);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(cc.getCcEmail());
        message.setSubject("Confirm Registration");
        message.setFrom("info@emranhss.com");
        message.setText("Dear " + cc.getCcCompanyName() + ", ");
        message.setText("Dear " + cc.getCcCompanyName() + "\n" + "To confirm your account, please click here :" +
                "http://localhost:8085/confirm-account?token=" + confirmationToken.getConfirmationToken());
        emailSenderService.sendEmail(message);
        m.addAttribute("msg", "User Registration Successful");
        return "redirect:/";
    }


    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public String confirmCorporatUser(@RequestParam("token") String token, Model m) {
        CorporateToken confirmationToken = tokenRepository.findByConfirmationToken(token);
        if(token != null){
            long endTime=System.currentTimeMillis();
            if (startTime>endTime){
                CorporateCustomer user = repo.findByEmail(confirmationToken.getUser().getCcEmail());
                user.setRole("CORPORATE_USER");
                user.setEnabled(true);
                repo.save(user);
                m.addAttribute("message","Account Verified" );
            }else{
                System.out.println("Time-----------Out");
            }
        } else {
            m.addAttribute("message", "The link is invalid or broken!");
        }
        return "redirect:/";
    }

    @RequestMapping("/cc_delete/{ccId}")
    public String ccDelete(@PathVariable("ccId") Integer ccId) {
        service.deleteCC(ccId);
        return "redirect:/cc_list";
    }

    @RequestMapping("/cc_edit/{ccId}")
    public String ccEditForm(@PathVariable("ccId") Integer ccId, Model m) {
        CorporateCustomer cc = service.findCCById(ccId);
        m.addAttribute("corporate", cc);
        return "cc_save_form";
    }


}
