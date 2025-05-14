package ntu.edu.nhom13.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Books")
public class BookEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    private String type;
    private String researchFields;
    private String publisher;
    private Date publishDate;
    private String attachment;

    // Getters, Setters
}
