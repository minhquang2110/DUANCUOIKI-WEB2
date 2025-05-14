package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.ProjectDto;
import ntu.edu.nhom13.entity.ProjectEntity;

import java.time.LocalDate;
import java.time.ZoneId;

public class ProjectMapper {

    public static ProjectDto toDto(ProjectEntity entity) {
        if (entity == null) {
            return null;
        }

        // Chuyển đổi từ Date sang LocalDate
        LocalDate startDate = entity.getStartDate() != null ? entity.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate endDate = entity.getEndDate() != null ? entity.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

        return ProjectDto.builder()
                .id(entity.getId())
                .projectCode(entity.getProjectCode())
                .projectName(entity.getProjectName())
                .projectLevel(entity.getProjectLevel())
                .hostOrganization(entity.getHostOrganization())
                .implementingOrg(entity.getImplementingOrg())
                .projectType(entity.getProjectType())
                .researchFields(entity.getResearchFields())
                .objective(entity.getObjective())
                .content(entity.getContent())
                .result(entity.getResult())
                .startDate(startDate)
                .endDate(endDate)
                .evaluation(entity.getEvaluation())
                .status(entity.getStatus())
                .productType(entity.getProductType())
                .applicationAddress(entity.getApplicationAddress())
                .budget(entity.getBudget())
                .attachment(entity.getAttachment())
                .build();
    }

    public static ProjectEntity toEntity(ProjectDto dto) {
        if (dto == null) {
            return null;
        }

        // Chuyển đổi từ LocalDate sang Date
        java.util.Date startDate = dto.getStartDate() != null ? java.util.Date.from(dto.getStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;
        java.util.Date endDate = dto.getEndDate() != null ? java.util.Date.from(dto.getEndDate().atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;

        return ProjectEntity.builder()
                .id(dto.getId())
                .projectCode(dto.getProjectCode())
                .projectName(dto.getProjectName())
                .projectLevel(dto.getProjectLevel())
                .hostOrganization(dto.getHostOrganization())
                .implementingOrg(dto.getImplementingOrg())
                .projectType(dto.getProjectType())
                .researchFields(dto.getResearchFields())
                .objective(dto.getObjective())
                .content(dto.getContent())
                .result(dto.getResult())
                .startDate(startDate)
                .endDate(endDate)
                .evaluation(dto.getEvaluation())
                .status(dto.getStatus())
                .productType(dto.getProductType())
                .applicationAddress(dto.getApplicationAddress())
                .budget(dto.getBudget())
                .attachment(dto.getAttachment())
                .build();
    }
}
