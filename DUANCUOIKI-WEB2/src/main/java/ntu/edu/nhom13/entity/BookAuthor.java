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
public class BookAuthor {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "bookID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "scientistID")
    private Scientist scientist;

    private Boolean isEditor = false;

    // Getters, Setters
}

