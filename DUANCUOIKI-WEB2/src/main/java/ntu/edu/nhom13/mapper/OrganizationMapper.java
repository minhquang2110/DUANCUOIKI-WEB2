package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.OrganizationDto;
import ntu.edu.nhom13.entity.OrganizationEntity;

public class OrganizationMapper {

    public static OrganizationDto toDto(OrganizationEntity entity) {
        if (entity == null) {
            return null;
        }

        return OrganizationDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmail())
                .build();
    }

    public static OrganizationEntity toEntity(OrganizationDto dto) {
        if (dto == null) {
            return null;
        }

        return OrganizationEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .build();
    }
}
