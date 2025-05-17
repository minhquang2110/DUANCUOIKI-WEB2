package ntu.edu.nhom13.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_authors")
public class BookAuthor {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scientist_id")
    private Scientist scientist;

    @Column(name = "is_editor")
    private Boolean isEditor = false;

    // Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Scientist getScientist() {
        return scientist;
    }
    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }
    public Boolean getIsEditor() {
        return isEditor;
    }
    public void setIsEditor(Boolean isEditor) {
        this.isEditor = isEditor;
    }
}
