package ntu.edu.nhom13.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class WorkHistoryDto {
    private Long id;
    private Long scientistId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private Long organizationId;
    private String position;
}
