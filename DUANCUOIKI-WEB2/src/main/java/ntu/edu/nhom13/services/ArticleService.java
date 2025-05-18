package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.Article;
import ntu.edu.nhom13.repositories.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Integer id) {
        return articleRepository.findById(id);
    }

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }
    // Phương thức tìm bài báo theo nhà khoa học
    public List<Article> findByScientistId(Integer scientistId) {
        return articleRepository.findByScientistId(scientistId);
    }

    // Phương thức đếm số lượng bài báo theo nhà khoa học
    public int countByScientistId(Integer scientistId) {
        return articleRepository.countByScientistId(scientistId);
    }

}
