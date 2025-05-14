package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.ScientistDto;
import ntu.edu.nhom13.entity.ScientistEntity;
import org.springframework.stereotype.Component;

@Component
public class ScientistMapper {

    public ScientistDto toDto(ScientistEntity entity) {
        if (entity == null) {
            return null;
        }
        return ScientistDto.builder()
                .id(entity.getId())
                .accountId(entity.getAccountEntity() != null ? entity.getAccountEntity().getAccountId() : null)  // Corrected here
                .fullName(entity.getFullName())
                .gender(entity.getGender())
                .birthYear(entity.getBirthYear())
                .image(entity.getImage())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmail())
                .degreeId(entity.getDegreeEntity() != null ? entity.getDegreeEntity().getId() : null)
                .rankId(entity.getRankEntity() != null ? entity.getRankEntity().getId() : null)
                .titleId(entity.getTitleEntity() != null ? entity.getTitleEntity().getId() : null)
                .fieldId(entity.getResearchFieldEntity() != null ? entity.getResearchFieldEntity().getId() : null)
                .organizationId(entity.getOrganizationEntity() != null ? entity.getOrganizationEntity().getId() : null)
                .languageLevelId(entity.getLanguageLevelEntity() != null ? entity.getLanguageLevelEntity().getId() : null)
                .major(entity.getMajor())
                .subMajor(entity.getSubMajor())
                .teachingSpecialty(entity.getTeachingSpecialty())
                .build();
    }

    public ScientistEntity toEntity(ScientistDto dto) {
        if (dto == null) {
            return null;
        }
        return ScientistEntity.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .gender(dto.getGender())
                .birthYear(dto.getBirthYear())
                .image(dto.getImage())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .major(dto.getMajor())
                .subMajor(dto.getSubMajor())
                .teachingSpecialty(dto.getTeachingSpecialty())
                .build();
    }
}
