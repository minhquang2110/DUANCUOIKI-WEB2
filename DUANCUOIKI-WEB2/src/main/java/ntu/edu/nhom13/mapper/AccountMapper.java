package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.AccountDto;
import ntu.edu.nhom13.entity.AccountEntity;

public class AccountMapper {

    public static AccountDto toDto(AccountEntity entity) {
        if (entity == null) {
            return null;
        }

        return AccountDto.builder()
                .accountId(entity.getAccountId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .role(entity.getRole() != null ? entity.getRole().name() : null)
                .build();
    }

    public static AccountEntity toEntity(AccountDto dto) {
        if (dto == null) {
            return null;
        }

        AccountEntity.Role role = null;
        if (dto.getRole() != null) {
            try {
                role = AccountEntity.Role.valueOf(dto.getRole());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid role: " + dto.getRole());
            }
        }

        return AccountEntity.builder()
                .accountId(dto.getAccountId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role(role)
                .build();
    }
}
