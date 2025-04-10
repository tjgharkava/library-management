package ge.temo.librarymanagement.model;

public class Book {
    private Long id;
    private String title;
    private String author;
    private boolean borrowed;
    private User borrower;

    public Book(Long id, String title, String author, boolean borrowed, User borrower) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = borrowed;
        this.borrower = borrower;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public void printDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Borrowed: " + isBorrowed());
        System.out.println("Borrower: ");
        borrower.printInfo();
    }
}
