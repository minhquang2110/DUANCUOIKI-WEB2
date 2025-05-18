package ntu.edu.nhom13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query("""
            SELECT DISTINCT a FROM Article a
            JOIN a.authors auth
            WHERE auth.id = :scientistId
        """)
        List<Article> findByScientistId(@Param("scientistId") Integer scientistId);

        @Query("""
            SELECT COUNT(a) FROM Article a
            JOIN a.authors auth
            WHERE auth.id = :scientistId
        """)
        int countByScientistId(@Param("scientistId") Integer scientistId);
}
