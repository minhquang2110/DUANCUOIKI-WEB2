package ntu.edu.nhom13.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "research_fields")
    private String researchFields;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "attachment")
    private String attachment;

    // Quan hệ nhiều-nhiều với Scientist thông qua bảng trung gian book_authors
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "book_authors", 
        joinColumns = @JoinColumn(name = "book_id"), 
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the researchFields
	 */
	public String getResearchFields() {
		return researchFields;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @return the publishDate
	 */
	public LocalDate getPublishDate() {
		return publishDate;
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
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @param researchFields the researchFields to set
	 */
	public void setResearchFields(String researchFields) {
		this.researchFields = researchFields;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}
