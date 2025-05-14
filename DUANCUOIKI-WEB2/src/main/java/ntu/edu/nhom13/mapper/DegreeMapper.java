package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.DegreeDto;
import ntu.edu.nhom13.entity.DegreeEntity;

public class DegreeMapper {

    // Method to convert DegreeDto to DegreeEntity
    public static DegreeEntity toEntity(DegreeDto dto) {
        if (dto == null) {
            return null;
        }

        return DegreeEntity.builder()
                .id(dto.getId())  // Directly use Long, no need to convert
                .name(dto.getName())
                .build();
    }

    // Method to convert DegreeEntity to DegreeDto
    public static DegreeDto toDto(DegreeEntity entity) {
        if (entity == null) {
            return null;
        }

        return DegreeDto.builder()
                .id(entity.getId())  // Directly use Long, no need to convert
                .name(entity.getName())
                .build();
    }
}
