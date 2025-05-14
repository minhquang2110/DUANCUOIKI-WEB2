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
public class EducationHistoryEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "scientistID")
    private ScientistEntity scientistEntity;

    private String level;
    private String institution;
    private String major;
    private Long graduationYear;

    // Getters, Setters
}
