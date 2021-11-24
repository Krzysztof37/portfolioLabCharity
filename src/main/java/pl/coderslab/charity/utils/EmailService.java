package pl.coderslab.charity.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private MailSender emailSender;


    public SimpleMailMessage makeMessage(String subject, String text, String name, String surname) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("krzysztofjez37@tlen.pl");
        message.setSubject(subject);
        message.setText(text + "\n" + name + " " + surname);
        emailSender.send(message);

        return message;
    }


}
