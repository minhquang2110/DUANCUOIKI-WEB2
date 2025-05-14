package ntu.edu.nhom13.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProjectParticipantDto {
    private Long id;
    private Long projectId;
    private Long scientistId;
    private Boolean isLeader;
}
