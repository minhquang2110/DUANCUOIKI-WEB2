package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.BookAuthorDto;
import ntu.edu.nhom13.entity.BookAuthorEntity;
import ntu.edu.nhom13.entity.BookEntity;
import ntu.edu.nhom13.entity.ScientistEntity;

public class BookAuthorMapper {

    public static BookAuthorDto toDto(BookAuthorEntity entity) {
        if (entity == null) {
            return null;
        }

        return BookAuthorDto.builder()
                .id(entity.getId())  // Get the ID from BookAuthorEntity
                .bookId(entity.getBookEntity() != null ? entity.getBookEntity().getId() : null)  // Use getId() for BookEntity
                .scientistId(entity.getScientistEntity() != null ? entity.getScientistEntity().getId() : null)  // Use getId() for ScientistEntity
                .isEditor(entity.getIsEditor())
                .build();
    }

    public static BookAuthorEntity toEntity(BookAuthorDto dto) {
        if (dto == null) {
            return null;
        }

        BookEntity book = null;
        if (dto.getBookId() != null) {
            book = BookEntity.builder()
                    .id(dto.getBookId())  // Use setId() for BookEntity
                    .build();
        }

        ScientistEntity scientist = null;
        if (dto.getScientistId() != null) {
            scientist = ScientistEntity.builder()
                    .id(dto.getScientistId())  // Use setId() for ScientistEntity
                    .build();
        }

        return BookAuthorEntity.builder()
                .id(dto.getId())
                .bookEntity(book)
                .scientistEntity(scientist)
                .isEditor(dto.getIsEditor() != null ? dto.getIsEditor() : false)
                .build();
    }
}
