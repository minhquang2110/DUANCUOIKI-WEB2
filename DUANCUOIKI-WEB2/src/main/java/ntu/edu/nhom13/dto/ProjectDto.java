package ntu.edu.nhom13.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {
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
    private LocalDate startDate;
    private LocalDate endDate;
    private String evaluation;
    private String status;
    private String productType;
    private String applicationAddress;
    private Double budget;
    private String attachment;
}
