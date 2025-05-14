package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.ProjectParticipantDto;
import ntu.edu.nhom13.entity.ProjectParticipantEntity;
import ntu.edu.nhom13.entity.ProjectEntity;
import ntu.edu.nhom13.entity.ScientistEntity;

public class ProjectParticipantMapper {

    // Method to convert ProjectParticipantEntity to ProjectParticipantDto
    public static ProjectParticipantDto toDto(ProjectParticipantEntity entity) {
        if (entity == null) {
            return null;
        }

        return ProjectParticipantDto.builder()
                .id(entity.getId())  // Use the getId() method for the ID
                .projectId(entity.getProjectEntity() != null ? entity.getProjectEntity().getId() : null)  // Use getId() for projectEntity
                .scientistId(entity.getScientistEntity() != null ? entity.getScientistEntity().getId() : null)  // Use getId() for scientistEntity
                .isLeader(entity.getIsLeader())  // Get the leader status
                .build();
    }

    // Method to convert ProjectParticipantDto to ProjectParticipantEntity
    public static ProjectParticipantEntity toEntity(ProjectParticipantDto dto) {
        if (dto == null) {
            return null;
        }

        ProjectEntity projectEntity = null;
        if (dto.getProjectId() != null) {
            projectEntity = new ProjectEntity();
            projectEntity.setId(dto.getProjectId());  // Set the project ID
        }

        ScientistEntity scientistEntity = null;
        if (dto.getScientistId() != null) {
            scientistEntity = new ScientistEntity();
            scientistEntity.setId(dto.getScientistId());  // Set the scientist ID
        }

        return ProjectParticipantEntity.builder()
                .id(dto.getId())  // Set the ID for the participant
                .projectEntity(projectEntity)  // Set the project entity
                .scientistEntity(scientistEntity)  // Set the scientist entity
                .isLeader(dto.getIsLeader())  // Set the leader status
                .build();
    }
}
