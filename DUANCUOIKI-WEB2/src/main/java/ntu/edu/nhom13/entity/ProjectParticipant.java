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
public class ProjectParticipant {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "projectID")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "scientistID")
    private Scientist scientist;

    private Boolean isLeader = false;

    // Getters, Setters
}

