package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.LanguageLevel;
import ntu.edu.nhom13.repositories.LanguageLevelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageLevelService {

    @Autowired
    private LanguageLevelRepository languageLevelRepository;

    public List<LanguageLevel> getAllLanguageLevels() {
        return languageLevelRepository.findAll();
    }

    public Optional<LanguageLevel> getLanguageLevelById(Integer id) {
        return languageLevelRepository.findById(id);
    }

    public LanguageLevel saveLanguageLevel(LanguageLevel languageLevel) {
        return languageLevelRepository.save(languageLevel);
    }

    public void deleteLanguageLevel(Integer id) {
        languageLevelRepository.deleteById(id);
    }

    public List<LanguageLevel> findAll() {
        return languageLevelRepository.findAll();
    }
}
