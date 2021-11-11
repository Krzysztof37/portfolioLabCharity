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
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.utils.CategoryRepository;
import pl.coderslab.charity.utils.DonationRepository;
import pl.coderslab.charity.utils.InstitutionRepository;
import pl.coderslab.charity.utils.UserRepository;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DonationController {

    private static CategoryRepository categoryRepository;
    private static InstitutionRepository institutionRepository;
    private static DonationRepository donationRepository;
    private static UserRepository userRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository,DonationRepository donationRepository, UserRepository userRepository) {
    this.categoryRepository = categoryRepository;
    this.institutionRepository = institutionRepository;
    this.donationRepository = donationRepository;
    this.userRepository = userRepository;
    }


    @GetMapping("/add/donation")
    public String addDonation(Model model, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);

        return "addDonationForm";
    }
    @PostMapping("/add/donation")
    public String addDonationPost(@Valid Donation donation, BindingResult result, Model model){
        System.out.println(donation.getCategory()+" "+donation.getInstitution()+" "+donation.getPickUpDate()+" "+donation.getPickUpTime());
        if(result.hasErrors()){
            model.addAttribute("error","podano nieprawidłowe dane, spróbuj jeszcze raz");
            model.addAttribute("errors", result.getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList()));
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
