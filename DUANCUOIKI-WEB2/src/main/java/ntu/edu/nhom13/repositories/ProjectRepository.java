package ntu.edu.nhom13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("""
            SELECT DISTINCT p FROM Project p
            JOIN ProjectParticipant pp ON pp.project = p
            WHERE pp.scientist.id = :scientistId
        """)
        List<Project> findByScientistId(@Param("scientistId") Integer scientistId);
}
