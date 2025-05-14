package ntu.edu.nhom13.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AdminDto {
    private Long adminId;
    private Long accountId;
    private String fullName;
    private String email;
    private String phoneNumber;
}

