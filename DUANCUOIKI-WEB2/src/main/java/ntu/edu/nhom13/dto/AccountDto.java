package ntu.edu.nhom13.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AccountDto {
    private Long accountId;
    private String username;
    private String password;
    private String role; // "Admin" or "Scientist"
}
