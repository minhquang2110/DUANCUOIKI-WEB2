package ntu.edu.nhom13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.EducationHistory;

@Repository
public interface EducationHistoryRepository extends JpaRepository<EducationHistory, Integer> {

	List<EducationHistory> findByScientistId(Integer scientistId);
}
