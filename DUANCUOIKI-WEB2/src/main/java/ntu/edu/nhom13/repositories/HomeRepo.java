package ntu.edu.nhom13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ntu.edu.nhom13.entity.ScientistEntity;

public interface HomeRepo extends JpaRepository<ScientistEntity, Integer>{
	@Query("SELECT s FROM ScientistEntity s")
    List<ScientistEntity> findAllScientists();
	
	
}