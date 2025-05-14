package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.AdminDto;
import ntu.edu.nhom13.entity.AccountEntity;
import ntu.edu.nhom13.entity.AdminEntity;

public class AdminMapper {

    public static AdminDto toDto(AdminEntity entity) {
        if (entity == null) {
            return null;
        }

        return AdminDto.builder()
                .adminId(entity.getAdminId())
                .accountId(entity.getAccountEntity() != null ? entity.getAccountEntity().getAccountId() : null)
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

    public static AdminEntity toEntity(AdminDto dto) {
        if (dto == null) {
            return null;
        }

        AccountEntity account = null;
        if (dto.getAccountId() != null) {
            account = AccountEntity.builder()
                    .accountId(dto.getAccountId())
                    .build();
            // Chỉ thiết lập accountId, cần fetch đầy đủ từ DB nếu cần dữ liệu khác
        }

        return AdminEntity.builder()
                .adminId(dto.getAdminId())
                .accountEntity(account)
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }
}
