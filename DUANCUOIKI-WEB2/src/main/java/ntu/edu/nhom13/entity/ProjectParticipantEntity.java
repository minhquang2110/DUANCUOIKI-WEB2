package ntu.edu.nhom13.entity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ProjectParticipants")
public class ProjectParticipantEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projectID")
    private ProjectEntity projectEntity;

    @ManyToOne
    @JoinColumn(name = "scientistID")
    private ScientistEntity scientistEntity;

    private Boolean isLeader = false;

    // Getters, Setters
}

