package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.WorkHistoryDto;
import ntu.edu.nhom13.entity.WorkHistoryEntity;
import ntu.edu.nhom13.entity.ScientistEntity;
import ntu.edu.nhom13.entity.OrganizationEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.LocalDate;

@Component
public class WorkHistoryMapper {

    // Convert WorkHistoryEntity to WorkHistoryDto
    public WorkHistoryDto toDto(WorkHistoryEntity entity) {
        if (entity == null) {
            return null;
        }

        // Convert Date to LocalDate for startDate and endDate
        LocalDate startDate = entity.getStartDate() != null ? entity.getStartDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate endDate = entity.getEndDate() != null ? entity.getEndDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate() : null;

        return WorkHistoryDto.builder()
                .id(entity.getId())
                .scientistId(entity.getScientistEntity() != null ? entity.getScientistEntity().getId() : null)
                .startDate(startDate)
                .endDate(endDate)
                .title(entity.getTitle())
                .organizationId(entity.getOrganizationEntity() != null ? entity.getOrganizationEntity().getId() : null)
                .position(entity.getPosition())
                .build();
    }

    // Convert WorkHistoryDto to WorkHistoryEntity
    public WorkHistoryEntity toEntity(WorkHistoryDto dto) {
        if (dto == null) {
            return null;
        }

        // Convert LocalDate to Date for startDate and endDate
        Date startDate = dto.getStartDate() != null ? java.sql.Date.valueOf(dto.getStartDate()) : null;
        Date endDate = dto.getEndDate() != null ? java.sql.Date.valueOf(dto.getEndDate()) : null;

        return WorkHistoryEntity.builder()
                .id(dto.getId())
                .startDate(startDate)
                .endDate(endDate)
                .title(dto.getTitle())
                .position(dto.getPosition())
                .build();
    }
}
