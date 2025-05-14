package ntu.edu.nhom13.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ArticleAuthorDto {
    private Long id;
    private Long articleId;
    private Long scientistId;
}
