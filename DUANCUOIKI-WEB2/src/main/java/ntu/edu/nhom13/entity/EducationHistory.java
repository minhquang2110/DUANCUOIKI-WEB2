package ntu.edu.nhom13.entity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EducationHistory")
public class EducationHistory {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "scientistID")
    private Scientist scientist;

    private String level;
    private String institution;
    private String major;
    private Integer graduationYear;

    // Getters, Setters
}
