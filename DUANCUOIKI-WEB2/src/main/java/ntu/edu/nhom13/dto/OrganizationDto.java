package ntu.edu.nhom13.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrganizationDto {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
}
