package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.ArticleAuthor;
import ntu.edu.nhom13.repositories.ArticleAuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleAuthorService {

    @Autowired
    private ArticleAuthorRepository articleAuthorRepository;

    public List<ArticleAuthor> getAllArticleAuthors() {
        return articleAuthorRepository.findAll();
    }

    public Optional<ArticleAuthor> getArticleAuthorById(Integer id) {
        return articleAuthorRepository.findById(id);
    }

    public ArticleAuthor saveArticleAuthor(ArticleAuthor articleAuthor) {
        return articleAuthorRepository.save(articleAuthor);
    }

    public void deleteArticleAuthor(Integer id) {
        articleAuthorRepository.deleteById(id);
    }
}
