package ntu.edu.nhom13.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EducationHistoryDto {
    private Long id;
    private Long scientistId;
    private String level;
    private String institution;
    private String major;
    private Long graduationYear;
}
