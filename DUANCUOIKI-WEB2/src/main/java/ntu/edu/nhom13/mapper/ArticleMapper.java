package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.ArticleDto;
import ntu.edu.nhom13.entity.ArticleEntity;

public class ArticleMapper {

    public static ArticleDto toDto(ArticleEntity entity) {
        if (entity == null) {
            return null;
        }

        return ArticleDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .journalName(entity.getJournalName())
                .issn(entity.getIssn())
                .volume(entity.getVolume())
                .issue(entity.getIssue())
                .pages(entity.getPages())
                .publisher(entity.getPublisher())
                .journalType(entity.getJournalType())
                .journalLevel(entity.getJournalLevel())
                .publicationYear(entity.getPublicationYear())
                .researchFields(entity.getResearchFields())
                .attachment(entity.getAttachment())
                .build();
    }

    public static ArticleEntity toEntity(ArticleDto dto) {
        if (dto == null) {
            return null;
        }

        return ArticleEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .journalName(dto.getJournalName())
                .issn(dto.getIssn())
                .volume(dto.getVolume())
                .issue(dto.getIssue())
                .pages(dto.getPages())
                .publisher(dto.getPublisher())
                .journalType(dto.getJournalType())
                .journalLevel(dto.getJournalLevel())
                .publicationYear(dto.getPublicationYear())
                .researchFields(dto.getResearchFields())
                .attachment(dto.getAttachment())
                .build();
    }
}
