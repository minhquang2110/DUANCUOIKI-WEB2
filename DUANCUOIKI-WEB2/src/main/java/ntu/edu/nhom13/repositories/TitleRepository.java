package ntu.edu.nhom13.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title, Integer> {
}
