package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.EducationHistory;
import ntu.edu.nhom13.repositories.EducationHistoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EducationHistoryService {

    @Autowired
    private EducationHistoryRepository educationHistoryRepository;

    public List<EducationHistory> getAllEducationHistories() {
        return educationHistoryRepository.findAll();
    }

    public Optional<EducationHistory> getEducationHistoryById(Integer id) {
        return educationHistoryRepository.findById(id);
    }

    public EducationHistory saveEducationHistory(EducationHistory educationHistory) {
        return educationHistoryRepository.save(educationHistory);
    }

    public void deleteEducationHistory(Integer id) {
        educationHistoryRepository.deleteById(id);
    }

	public List<EducationHistory> findByScientistId(Integer id) {
		return educationHistoryRepository.findByScientistId(id);
	}
	public Optional<EducationHistory> findByIdAndScientistId(Integer id, Integer scientistId) {
	    return educationHistoryRepository.findByIdAndScientistId(id, scientistId);
	}
	
	public Optional<EducationHistory> findById(Integer id) {
	    return educationHistoryRepository.findById(id);
	}

}
