package ntu.edu.nhom13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("""
            SELECT DISTINCT b FROM Book b
            JOIN BookAuthor ba ON ba.book = b
            WHERE ba.scientist.id = :scientistId
        """)
        List<Book> findByScientistId(@Param("scientistId") Integer scientistId);
}
