package pl.coderslab.charity.utils;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.utils.repository.InstitutionRepository;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public Iterable<Institution> allInstitutions() {
        return institutionRepository.findAll();
    }


}
