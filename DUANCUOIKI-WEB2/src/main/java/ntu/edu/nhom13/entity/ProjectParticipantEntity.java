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
    @JoinColumn(name = "project_id")
    private ProjectEntity projectEntity;

    @ManyToOne
    @JoinColumn(name = "scientist_id")
    private ScientistEntity scientistEntity;

    private Boolean isLeader = false;

    // Getters, Setters
}

