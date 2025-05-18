package ntu.edu.nhom13.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "article_authors")
public class ArticleAuthor {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scientist_id")
    private Scientist scientist;

    // Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }
    public Scientist getScientist() {
        return scientist;
    }
    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }
}
