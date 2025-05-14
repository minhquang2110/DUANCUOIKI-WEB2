package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.TitleDto;
import ntu.edu.nhom13.entity.TitleEntity;
import org.springframework.stereotype.Component;

@Component
public class TitleMapper {

    // Convert TitleEntity to TitleDto
    public TitleDto toDto(TitleEntity entity) {
        if (entity == null) {
            return null;
        }
        return TitleDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    // Convert TitleDto to TitleEntity
    public TitleEntity toEntity(TitleDto dto) {
        if (dto == null) {
            return null;
        }
        return TitleEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
