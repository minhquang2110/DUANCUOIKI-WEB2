package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.WorkHistory;
import ntu.edu.nhom13.repositories.WorkHistoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkHistoryService {

    @Autowired
    private WorkHistoryRepository workHistoryRepository;

    public List<WorkHistory> getAllWorkHistories() {
        return workHistoryRepository.findAll();
    }

    public Optional<WorkHistory> getWorkHistoryById(Integer id) {
        return workHistoryRepository.findById(id);
    }

    public WorkHistory saveWorkHistory(WorkHistory workHistory) {
        return workHistoryRepository.save(workHistory);
    }

    public void deleteWorkHistory(Integer id) {
        workHistoryRepository.deleteById(id);
    }

	public List<WorkHistory> findByScientistId(Integer id) {
		return workHistoryRepository.findByScientistId(id);
	}
}
