package ntu.edu.nhom13.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookDto {
    private Long id;
    private String title;
    private String type;
    private String researchFields;
    private String publisher;
    private LocalDate publishDate;
    private String attachment;
}
