package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.ResearchField;
import ntu.edu.nhom13.repositories.ResearchFieldRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResearchFieldService {

    @Autowired
    private ResearchFieldRepository researchFieldRepository;

    public List<ResearchField> getAllResearchFields() {
        return researchFieldRepository.findAll();
    }

    public Optional<ResearchField> getResearchFieldById(Integer id) {
        return researchFieldRepository.findById(id);
    }

    public ResearchField saveResearchField(ResearchField researchField) {
        return researchFieldRepository.save(researchField);
    }

    public void deleteResearchField(Integer id) {
        researchFieldRepository.deleteById(id);
    }

    public List<ResearchField> findAll() {
        return researchFieldRepository.findAll();
    }
}
