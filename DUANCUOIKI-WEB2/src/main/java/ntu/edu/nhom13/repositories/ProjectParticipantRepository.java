package ntu.edu.nhom13.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import ntu.edu.nhom13.entity.Project;
import ntu.edu.nhom13.entity.ProjectParticipant;

@Repository
public interface ProjectParticipantRepository extends JpaRepository<ProjectParticipant, Integer> {
	@Query("SELECT pp.project FROM ProjectParticipant pp WHERE pp.scientist.id = :scientistId")
    List<Project> findProjectsByScientistId(@Param("scientistId") Integer scientistId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProjectParticipant b WHERE b.scientist.id = :scientistId")
    void deleteByScientist_Id(@Param("scientistId") Integer scientistId);

}
