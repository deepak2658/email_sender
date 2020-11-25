package com.example.emailsender.email;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class EmailController {

    @Autowired
    private EmailService emailService;



    @GetMapping("/signup-success")
    private String emailSender(){

        EmailModel emailModel = new EmailModel("Dan","Vega","deep8009244397@gmail.com");

        try {
            emailService.sendNotification(emailModel);
        }catch (MailException e){
             System.out.println(e);
        }
        //send a notification

        return "Thank you for registering with us";
    }
}
