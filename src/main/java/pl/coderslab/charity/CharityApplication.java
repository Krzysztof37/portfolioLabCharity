package pl.coderslab.charity;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;

import java.beans.JavaBean;

@SpringBootApplication
public class CharityApplication {




    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

}
