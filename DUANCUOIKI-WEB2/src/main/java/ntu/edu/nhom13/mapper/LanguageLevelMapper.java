package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.LanguageLevelDto;
import ntu.edu.nhom13.entity.LanguageLevelEntity;

public class LanguageLevelMapper {

    public static LanguageLevelDto toDto(LanguageLevelEntity entity) {
        if (entity == null) {
            return null;
        }

        return LanguageLevelDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static LanguageLevelEntity toEntity(LanguageLevelDto dto) {
        if (dto == null) {
            return null;
        }

        return LanguageLevelEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
