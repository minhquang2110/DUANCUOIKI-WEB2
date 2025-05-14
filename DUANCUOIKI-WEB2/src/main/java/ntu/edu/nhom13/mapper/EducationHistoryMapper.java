package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.EducationHistoryDto;
import ntu.edu.nhom13.entity.EducationHistoryEntity;
import ntu.edu.nhom13.entity.ScientistEntity;

public class EducationHistoryMapper {

    public static EducationHistoryDto toDto(EducationHistoryEntity entity) {
        if (entity == null) {
            return null;
        }

        return EducationHistoryDto.builder()
                .id(entity.getId())
                .scientistId(entity.getScientistEntity() != null ? entity.getScientistEntity().getId() : null)  // Use getId()
                .level(entity.getLevel())
                .institution(entity.getInstitution())
                .major(entity.getMajor())
                .graduationYear(entity.getGraduationYear())
                .build();
    }

    public static EducationHistoryEntity toEntity(EducationHistoryDto dto) {
        if (dto == null) {
            return null;
        }

        ScientistEntity scientistEntity = null;
        if (dto.getScientistId() != null) {
            scientistEntity = new ScientistEntity();
            scientistEntity.setId(dto.getScientistId());  // Use setId() to set the ID
        }

        return EducationHistoryEntity.builder()
                .id(dto.getId())
                .scientistEntity(scientistEntity)
                .level(dto.getLevel())
                .institution(dto.getInstitution())
                .major(dto.getMajor())
                .graduationYear(dto.getGraduationYear())
                .build();
    }
}
