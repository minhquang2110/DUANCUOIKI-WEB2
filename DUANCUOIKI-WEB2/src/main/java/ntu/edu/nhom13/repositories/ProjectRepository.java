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
            JOIN p.participants participant
            WHERE participant.id = :scientistId
        """)
        List<Project> findByScientistId(@Param("scientistId") Integer scientistId);

        @Query("""
            SELECT COUNT(p) FROM Project p
            JOIN p.participants participant
            WHERE participant.id = :scientistId
        """)
        int countByScientistId(@Param("scientistId") Integer scientistId);

}
