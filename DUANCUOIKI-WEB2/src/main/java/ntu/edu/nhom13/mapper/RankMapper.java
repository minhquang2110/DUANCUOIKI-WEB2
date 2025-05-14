package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.RankDto;
import ntu.edu.nhom13.entity.RankEntity;

public class RankMapper {

    public static RankDto toDto(RankEntity entity) {
        if (entity == null) {
            return null;
        }

        return RankDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static RankEntity toEntity(RankDto dto) {
        if (dto == null) {
            return null;
        }

        return RankEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
