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
@Table(name = "Projects")
public class ProjectEntity {
    @Id
    private Long id;

    private String projectCode;
    private String projectName;
    private String projectLevel;
    private String hostOrganization;
    private String implementingOrg;
    private String projectType;
    private String researchFields;
    private String objective;
    private String content;
    private String result;
    private Date startDate;
    private Date endDate;
    private String evaluation;
    private String status;
    private String productType;
    private String applicationAddress;
    private Double budget;

    @Column(columnDefinition = "TEXT")
    private String attachment;

    // Getters, Setters
}

