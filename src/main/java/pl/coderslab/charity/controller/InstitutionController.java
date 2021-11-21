package pl.coderslab.charity.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.utils.repository.InstitutionRepository;
import pl.coderslab.charity.utils.InstitutionService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@Secured("ROLE_ADMIN")
public class InstitutionController {

    private final InstitutionRepository institutionRepository;
    private final InstitutionService institutionService;

    public InstitutionController(InstitutionRepository institutionRepository, InstitutionService institutionService) {
    this.institutionRepository = institutionRepository;
        this.institutionService = institutionService;
    }


    @GetMapping("/institution/list")
    public String getInstitutionsList(Model model, HttpServletRequest request, Pageable pageable){

        Page<Institution> institutionList = institutionRepository.findAll(pageable);

        model.addAttribute("institutionsList", institutionList);

        return "institutionsList";
    }

    @GetMapping("/institution/delete/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionRepository.deleteById(id);
        return "redirect:/institution/list";
    }

    @PostMapping("/institution/add")
    public String institutionAdd(@Valid Institution institution, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("errorsInstitution", result.getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList()));
            return "institutionsList";
        }
        institutionRepository.save(institution);
        return "redirect:/institution/list";
    }


}
