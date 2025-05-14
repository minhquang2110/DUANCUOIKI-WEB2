package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.ResearchFieldDto;
import ntu.edu.nhom13.entity.ResearchFieldEntity;

public class ResearchFieldMapper {

    public static ResearchFieldDto toDto(ResearchFieldEntity entity) {
        if (entity == null) {
            return null;
        }

        return ResearchFieldDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentFieldId(entity.getParentFieldEntity() != null ? entity.getParentFieldEntity().getId() : null)
                .description(entity.getDescription())
                .code(entity.getCode())
                .build();
    }

    public static ResearchFieldEntity toEntity(ResearchFieldDto dto) {
        if (dto == null) {
            return null;
        }

        ResearchFieldEntity parentFieldEntity = null;
        if (dto.getParentFieldId() != null) {
            parentFieldEntity = new ResearchFieldEntity();
            parentFieldEntity.setId(dto.getParentFieldId());
        }

        return ResearchFieldEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .parentFieldEntity(parentFieldEntity)
                .description(dto.getDescription())
                .code(dto.getCode())
                .build();
    }
}
