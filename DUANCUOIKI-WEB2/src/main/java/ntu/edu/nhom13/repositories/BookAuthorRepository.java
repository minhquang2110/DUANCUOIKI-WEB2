package ntu.edu.nhom13.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.BookAuthor;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM BookAuthor b WHERE b.scientist.id = :scientistId")
    void deleteByScientist_Id(@Param("scientistId") Integer scientistId);
}
