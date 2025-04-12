package ge.temo.librarymanagement.persistance;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
@SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq", allocationSize = 1)
public class Book {
    @Id
    @GeneratedValue(generator = "book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "is_borrowed")
    private Boolean borrowed;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private User borrower;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }
}
