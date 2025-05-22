package ntu.edu.nhom13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.ResearchField;

@Repository
public interface ResearchFieldRepository extends JpaRepository<ResearchField, Integer> {

    List<ResearchField> findByParentFieldId(Integer parentFieldId);
}
