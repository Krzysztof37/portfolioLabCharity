package pl.coderslab.charity;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.utils.EmailService;
import pl.coderslab.charity.utils.repository.DonationRepository;
import pl.coderslab.charity.utils.repository.InstitutionRepository;


import java.util.List;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final EmailService emailService;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository, EmailService emailService) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.emailService = emailService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutionList = institutionRepository.findAll();
        Long numberOfDonation = donationRepository.count();
        Integer numberOfBag = donationRepository.SumOfBag();

        if (numberOfBag == null) {
            numberOfBag = 0;
        }

        model.addAttribute("institutionList", institutionList);
        model.addAttribute("numberOfDonation", numberOfDonation);
        model.addAttribute("numberOfBag", numberOfBag);

        return "index";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@Param("message") String message, @Param("name") String name, @Param("surname") String surname) {

        emailService.makeMessage("Wiadomość z formularza (Charity)", message, name, surname);

        return "redirect:/";
    }
}
