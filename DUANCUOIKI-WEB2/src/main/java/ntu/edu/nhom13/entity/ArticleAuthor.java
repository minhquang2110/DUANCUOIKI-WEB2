package ntu.edu.nhom13.entity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ArticleAuthors")
public class ArticleAuthor {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "articleID")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "scientistID")
    private Scientist scientist;

    // Getters, Setters
}

