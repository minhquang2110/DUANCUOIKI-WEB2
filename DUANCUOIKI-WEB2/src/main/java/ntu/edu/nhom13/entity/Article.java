package ntu.edu.nhom13.entity;

import java.util.List;

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

    // Quan hệ nhiều-nhiều với Scientist qua bảng trung gian article_authors
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "article_authors", 
        joinColumns = @JoinColumn(name = "article_id"), 
        inverseJoinColumns = @JoinColumn(name = "scientist_id")
    )
    private List<Scientist> authors;

    public List<Scientist> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Scientist> authors) {
        this.authors = authors;
    }
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the journalName
	 */
	public String getJournalName() {
		return journalName;
	}
	/**
	 * @return the issn
	 */
	public String getIssn() {
		return issn;
	}
	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}
	/**
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}
	/**
	 * @return the pages
	 */
	public String getPages() {
		return pages;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @return the journalType
	 */
	public String getJournalType() {
		return journalType;
	}
	/**
	 * @return the journalLevel
	 */
	public String getJournalLevel() {
		return journalLevel;
	}
	/**
	 * @return the publicationYear
	 */
	public Integer getPublicationYear() {
		return publicationYear;
	}
	/**
	 * @return the researchFields
	 */
	public String getResearchFields() {
		return researchFields;
	}
	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param journalName the journalName to set
	 */
	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
	/**
	 * @param issn the issn to set
	 */
	public void setIssn(String issn) {
		this.issn = issn;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}
	/**
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}
	/**
	 * @param pages the pages to set
	 */
	public void setPages(String pages) {
		this.pages = pages;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @param journalType the journalType to set
	 */
	public void setJournalType(String journalType) {
		this.journalType = journalType;
	}
	/**
	 * @param journalLevel the journalLevel to set
	 */
	public void setJournalLevel(String journalLevel) {
		this.journalLevel = journalLevel;
	}
	/**
	 * @param publicationYear the publicationYear to set
	 */
	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	/**
	 * @param researchFields the researchFields to set
	 */
	public void setResearchFields(String researchFields) {
		this.researchFields = researchFields;
	}
	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

    // Các getter và setter còn lại
    // ...
}