package com.example.myFinalProject.services;

import com.example.myFinalProject.model.ContactUs;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ContactUsService {

    public void sendEmail(ContactUs contactUsRequest) {
        Email email = formEmail(contactUsRequest);
        try {
            email.setMsg(contactUsRequest.getMessage()); // message from HTML-form
            email.setFrom("bastbagslietuva@gmail.com");
            email.addTo("bastbagslietuva@gmail.com");
            email.send(); // will throw email-exception if something is wrong
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    Email formEmail(ContactUs contactUsRequest) {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("bastbagslietuva@gmail.com", "korona2020"));
        email.setSSLOnConnect(true);
        email.setSubject(contactUsRequest.getFirstName()); // subject from HTML-form
        return email;
    }


}
