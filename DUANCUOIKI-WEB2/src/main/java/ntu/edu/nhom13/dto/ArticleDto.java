package ntu.edu.nhom13.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ArticleDto {
    private Long id;
    private String title;
    private String journalName;
    private String issn;
    private String volume;
    private String issue;
    private String pages;
    private String publisher;
    private String journalType;
    private String journalLevel;
    private Long publicationYear;
    private String researchFields;
    private String attachment;
}
