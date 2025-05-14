package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.BookDto;
import ntu.edu.nhom13.entity.BookEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BookMapper {

    public static BookDto toDto(BookEntity entity) {
        if (entity == null) {
            return null;
        }

        LocalDate publishDate = null;
        if (entity.getPublishDate() != null) {
            publishDate = entity.getPublishDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }

        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .type(entity.getType())
                .researchFields(entity.getResearchFields())
                .publisher(entity.getPublisher())
                .publishDate(publishDate)
                .attachment(entity.getAttachment())
                .build();
    }

    public static BookEntity toEntity(BookDto dto) {
        if (dto == null) {
            return null;
        }

        Date publishDate = null;
        if (dto.getPublishDate() != null) {
            publishDate = java.sql.Date.valueOf(dto.getPublishDate());
        }

        return BookEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .type(dto.getType())
                .researchFields(dto.getResearchFields())
                .publisher(dto.getPublisher())
                .publishDate(publishDate)
                .attachment(dto.getAttachment())
                .build();
    }
}
