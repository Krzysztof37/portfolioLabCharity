package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.utils.DonationRepository;
import pl.coderslab.charity.utils.InstitutionRepository;


import java.util.List;


@Controller
public class HomeController {

    private static InstitutionRepository institutionRepository;
    private static DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
    this.institutionRepository = institutionRepository;
    this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionList = institutionRepository.findAll();
        Long numberOfDonation = donationRepository.count();
        Integer numberOfBag = donationRepository.SumOfBag();
        if(numberOfBag == null){
            numberOfBag = 0;
        }
        model.addAttribute("institutionList", institutionList);
        model.addAttribute("numberOfDonation", numberOfDonation);
        model.addAttribute("numberOfBag", numberOfBag);

        return "index";
    }
}
