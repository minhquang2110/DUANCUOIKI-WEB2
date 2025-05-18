package ntu.edu.nhom13.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Integer> {
}
