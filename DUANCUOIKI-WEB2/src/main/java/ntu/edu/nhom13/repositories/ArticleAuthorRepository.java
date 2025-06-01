package ntu.edu.nhom13.repositories;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.Article;
import ntu.edu.nhom13.entity.ArticleAuthor;

@Repository
public interface ArticleAuthorRepository extends JpaRepository<ArticleAuthor, Integer> {
	@Query("SELECT aa.article FROM ArticleAuthor aa WHERE aa.scientist.id = :scientistId")
	List<Article> findArticlesByScientistId(@Param("scientistId") Integer scientistId);

	@Transactional
	@Modifying
	@Query("DELETE FROM ArticleAuthor b WHERE b.scientist.id = :scientistId")
	void deleteByScientist_Id(@Param("scientistId") Integer scientistId);
}
