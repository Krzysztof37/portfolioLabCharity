package pl.coderslab.charity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CharityApplication {

    @Bean
    FilterRegistrationBean < AuthFilter > filterRegistrationBean(){
        FilterRegistrationBean < AuthFilter > registrationBean = new FilterRegistrationBean<>();
        AuthFilter authFilter = new AuthFilter();

        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns("/add/donation");
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

}
