package ntu.edu.nhom13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.Book;
import ntu.edu.nhom13.entity.Project;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	@Query("""
	  SELECT DISTINCT b FROM Book b
	  JOIN b.authors a
	  WHERE a.id = :scientistId
	""")
	List<Book> findByScientistId(@Param("scientistId") Integer scientistId);

	@Query("""
	  SELECT COUNT(b) FROM Book b
	  JOIN b.authors a
	  WHERE a.id = :scientistId
	""")
	int countByScientistId(@Param("scientistId") Integer scientistId);

}
