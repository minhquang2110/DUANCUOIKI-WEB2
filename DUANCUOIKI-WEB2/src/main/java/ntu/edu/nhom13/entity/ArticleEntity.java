package ntu.edu.nhom13.entity;
import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Articles")
public class ArticleEntity {
    @Id
    private Long id;

    private String title;
    private String journalName;
    private String issn;
    private String volume;
    private String issue;
    private String pages;
    private String publisher;
    private String journalType;
    private String journalLevel;
    private Long publicationYear;
    private String researchFields;
    private String attachment;

    // Getters, Setters
}
