package ntu.edu.nhom13.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookAuthorDto {
    private Long id;
    private Long bookId;
    private Long scientistId;
    private Boolean isEditor;
}
