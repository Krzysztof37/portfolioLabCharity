package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.utils.CategoryRepository;
import pl.coderslab.charity.utils.DonationRepository;
import pl.coderslab.charity.utils.InstitutionRepository;


import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {

    private static CategoryRepository categoryRepository;
    private static InstitutionRepository institutionRepository;
    private static DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository,DonationRepository donationRepository) {
    this.categoryRepository = categoryRepository;
    this.institutionRepository = institutionRepository;
    this.donationRepository = donationRepository;
    }


    @GetMapping("/add/donation")
    public String addDonation(Model model){
        model.addAttribute("donation", new Donation());
        return "addDonationForm";
    }
    @PostMapping("/add/donation")
    public String addDonationPost(@Valid Donation donation, BindingResult result){
        if(result.hasErrors()){
            return "addDonationForm";
        }
        donationRepository.save(donation);
        return "redirect:/";
    }

    @ModelAttribute("categories")
    public List<Category> getCategory (){
        return categoryRepository.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> getInstitutions(){
        return institutionRepository.findAll();

    }

}
