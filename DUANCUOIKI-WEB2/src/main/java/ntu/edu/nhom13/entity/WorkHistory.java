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
@Table(name = "WorkHistory")
public class WorkHistory {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "scientistID")
    private Scientist scientist;

    private Date startDate;
    private Date endDate;
    private String title;

    @ManyToOne
    @JoinColumn(name = "organizationID")
    private Organization organization;

    private String position;

    // Getters, Setters
}

