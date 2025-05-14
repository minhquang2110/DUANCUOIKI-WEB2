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
    @JoinColumn(name = "articleID")
    private ArticleEntity articleEntity;

    @ManyToOne
    @JoinColumn(name = "scientistID")
    private ScientistEntity scientistEntity;

    // Getters, Setters
}

