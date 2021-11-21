package pl.coderslab.charity.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.utils.*;
import pl.coderslab.charity.utils.repository.CategoryRepository;
import pl.coderslab.charity.utils.repository.DonationRepository;
import pl.coderslab.charity.utils.repository.InstitutionRepository;
import pl.coderslab.charity.utils.repository.UserRepository;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository,DonationRepository donationRepository, UserRepository userRepository) {
    this.categoryRepository = categoryRepository;
    this.institutionRepository = institutionRepository;
    this.donationRepository = donationRepository;
    this.userRepository = userRepository;
    }


    @GetMapping("/donation/list")
    public String donationList (Model model, Pageable pageable){

        Page<Donation> donationList = donationRepository.findAll(pageable);
        model.addAttribute("donationList", donationList);

        return "donationList";
    }

    @GetMapping("/donation/archive/list")
    public String donationArchiveList(Model model, Pageable pageable){

        Page<Donation> donationArchiveList = donationRepository.findAll(pageable);
        model.addAttribute("donationArchiveList", donationArchiveList);

        return "donationArchiveList";
    }

    @GetMapping("/donation/delete/{id}")
    public String donationDelete (@PathVariable Long id){
        donationRepository.deleteById(id);
        return "redirect:/donation/list";
    }



    @GetMapping("/donation/archive/{id}")
    public String donationArchive(@PathVariable Long id){
        donationRepository.archiveDonation(id);
        return "redirect:/donation/list";
    }



    @GetMapping("/add/donation")
    public String addDonation(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", currentUser.getUser());
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
