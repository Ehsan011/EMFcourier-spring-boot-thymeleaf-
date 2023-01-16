package org.idb.emf.EMFCourier.service;

import org.idb.emf.EMFCourier.entity.CorporateCustomer;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailService {

        private final JavaMailSender javaMailSender;

        public EmailService(JavaMailSender javaMailSender) {
            this.javaMailSender = javaMailSender;
        }

        public void sendMail(CorporateCustomer user) throws MessagingException {
            javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject("Welcome " + user.getCcCompanyName());

            String html = "<!doctype html>\n" +
                    "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                    "      xmlns:th=\"http://www.thymeleaf.org\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\"\n" +
                    "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                    "    <title>Email</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div>Welcome <b>" + user.getCcCompanyName() + "</b></div>\n" +
                    "\n" +
                    "<div> Your username is <b>" + " EMF Courier " + "</b></div>\n" +
                    "<div> Any Information Please Call <b>" + " 01716371264 " + "</b></div>\n" +
                    "</body>\n" +
                    "</html>\n";
            helper.setText(html, true);
            helper.setTo(user.getCcEmail());
            javaMailSender.send(mimeMessage);
        }
    }

