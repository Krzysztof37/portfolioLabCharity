package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.utils.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InstitutionController {

    private static InstitutionRepository institutionRepository;

    public InstitutionController(InstitutionRepository institutionRepository) {
    this.institutionRepository = institutionRepository;
    }

    @GetMapping("/institution/list")
    public String getInstitutionsList(Model model){

        List<Institution> institutionsList = institutionRepository.findAll();
        model.addAttribute("institutionsList", institutionsList);

        return "institutionsList";
    }

    @GetMapping("/institution/delete/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionRepository.deleteById(id);
        return "redirect:/institution/list";
    }

    @PostMapping("/institution/add")
    public String institutionAdd(@Valid Institution institution, BindingResult result){

        if(result.hasErrors()){
            return "redirect:/institution/list";
        }
        institutionRepository.save(institution);
        return "redirect:/institution/list";
    }


}
