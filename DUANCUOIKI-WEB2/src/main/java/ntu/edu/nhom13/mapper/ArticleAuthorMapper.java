package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.ArticleAuthorDto;
import ntu.edu.nhom13.entity.ArticleAuthorEntity;
import ntu.edu.nhom13.entity.ArticleEntity;
import ntu.edu.nhom13.entity.ScientistEntity;

public class ArticleAuthorMapper {

    public static ArticleAuthorDto toDto(ArticleAuthorEntity entity) {
        if (entity == null) {
            return null;
        }

        return ArticleAuthorDto.builder()
                .id(entity.getId())
                .articleId(entity.getArticleEntity() != null ? entity.getArticleEntity().getId() : null)  // Use getId() instead of getArticleId()
                .scientistId(entity.getScientistEntity() != null ? entity.getScientistEntity().getId() : null) // Use getId() for ScientistEntity
                .build();
    }

    public static ArticleAuthorEntity toEntity(ArticleAuthorDto dto) {
        if (dto == null) {
            return null;
        }

        ArticleEntity article = null;
        if (dto.getArticleId() != null) {
            article = ArticleEntity.builder()
                    .id(dto.getArticleId())  // Use setId() for ArticleEntity
                    .build();
        }

        ScientistEntity scientist = null;
        if (dto.getScientistId() != null) {
            scientist = ScientistEntity.builder()
                    .id(dto.getScientistId())  // Use setId() for ScientistEntity
                    .build();
        }

        return ArticleAuthorEntity.builder()
                .id(dto.getId())
                .articleEntity(article)
                .scientistEntity(scientist)
                .build();
    }
}
