package ntu.edu.nhom13.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.Project;
import ntu.edu.nhom13.entity.Scientist;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScientistRepository extends JpaRepository<Scientist, Integer> {
    Scientist findByEmail(String email);
    Optional<Scientist> findById(Integer id);
    List<Scientist> findByFullNameContainingIgnoreCase(String keyword);
    @Query("""
    	    SELECT DISTINCT s FROM Scientist s
    	    LEFT JOIN FETCH s.degree
    	    LEFT JOIN FETCH s.rank
    	    LEFT JOIN FETCH s.title
    	    LEFT JOIN FETCH s.researchField
    	    LEFT JOIN FETCH s.organization
    	    LEFT JOIN FETCH s.workHistories
    	    LEFT JOIN FETCH s.educationHistories
    	    WHERE s.id = :id
    	""")
    	Optional<Scientist> findByIdWithRelations(@Param("id") Integer id);
    
    @Query("SELECT s FROM Scientist s WHERE s.account.id = :accountId")
    Scientist findScientistByAccountId(@Param("accountId") Integer accountId);
}
