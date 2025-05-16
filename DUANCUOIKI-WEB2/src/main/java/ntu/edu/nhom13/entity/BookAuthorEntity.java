package ntu.edu.nhom13.entity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BookAuthors")
public class BookAuthorEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    @ManyToOne
    @JoinColumn(name = "scientist_id")
    private ScientistEntity scientistEntity;

    private Boolean isEditor = false;

    // Getters, Setters
}

