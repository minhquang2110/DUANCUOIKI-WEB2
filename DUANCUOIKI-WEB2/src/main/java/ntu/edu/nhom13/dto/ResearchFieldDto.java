package ntu.edu.nhom13.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ResearchFieldDto {
    private Long id;
    private String name;
    private Long parentFieldId;
    private String description;
    private String code;
}
