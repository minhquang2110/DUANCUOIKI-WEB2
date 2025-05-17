package ntu.edu.nhom13.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "journal_name")
    private String journalName;

    @Column(name = "issn")
    private String issn;

    @Column(name = "volume")
    private String volume;

    @Column(name = "issue")
    private String issue;

    @Column(name = "pages")
    private String pages;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "journal_type")
    private String journalType;

    @Column(name = "journal_level")
    private String journalLevel;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "research_fields")
    private String researchFields;

    @Column(name = "attachment", columnDefinition = "TEXT")
    private String attachment;

    // Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getJournalName() {
        return journalName;
    }
    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }
    public String getIssn() {
        return issn;
    }
    public void setIssn(String issn) {
        this.issn = issn;
    }
    public String getVolume() {
        return volume;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getIssue() {
        return issue;
    }
    public void setIssue(String issue) {
        this.issue = issue;
    }
    public String getPages() {
        return pages;
    }
    public void setPages(String pages) {
        this.pages = pages;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getJournalType() {
        return journalType;
    }
    public void setJournalType(String journalType) {
        this.journalType = journalType;
    }
    public String getJournalLevel() {
        return journalLevel;
    }
    public void setJournalLevel(String journalLevel) {
        this.journalLevel = journalLevel;
    }
    public Integer getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
    public String getResearchFields() {
        return researchFields;
    }
    public void setResearchFields(String researchFields) {
        this.researchFields = researchFields;
    }
    public String getAttachment() {
        return attachment;
    }
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
