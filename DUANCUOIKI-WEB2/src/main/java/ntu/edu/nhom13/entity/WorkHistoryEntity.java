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
public class WorkHistoryEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "scientist_id")
    private ScientistEntity scientistEntity;

    private Date startDate;
    private Date endDate;
    private String title;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organizationEntity;

    private String position;

    // Getters, Setters
}

