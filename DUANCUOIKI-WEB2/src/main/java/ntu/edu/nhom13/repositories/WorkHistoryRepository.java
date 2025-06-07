package ntu.edu.nhom13.repositories;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.WorkHistory;

@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Integer> {

	List<WorkHistory> findByScientistId(Integer scientistId);

	@Transactional
	@Modifying
	@Query("DELETE FROM WorkHistory b WHERE b.scientist.id = :scientistId")
	void deleteByScientist_Id(@Param("scientistId") Integer scientistId);

	Optional<WorkHistory> findByIdAndScientistId(Integer id, Integer scientistId);

}
