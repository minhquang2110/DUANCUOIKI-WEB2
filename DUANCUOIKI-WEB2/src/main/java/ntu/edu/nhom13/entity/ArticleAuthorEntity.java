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
public class ArticleAuthorEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleEntity articleEntity;

    @ManyToOne
    @JoinColumn(name = "scientist_id")
    private ScientistEntity scientistEntity;

    // Getters, Setters
}

