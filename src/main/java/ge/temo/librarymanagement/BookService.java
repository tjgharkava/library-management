package ge.temo.librarymanagement;

import ge.temo.librarymanagement.model.Book;
import ge.temo.librarymanagement.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    public final List<Book> books = new ArrayList<>();

    @PostConstruct
    public void setup() {
        books.add(new Book(1L, "Data Tutashkhia", "Tchabua Amirejibi", true,
                new User(1L, "tjgharkava")));
        books.add(new Book(2L, "The Knight in the Panther's Skin", "Shota Rustaveli", true,
                new User(2L, "elon.musk")));
        books.add(new Book(3L, "Murder on the Orient Express", "Agatha Christie", false,
                new User(3L, "donald_duck")));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(Long id, Book book) {
        Book bookToUpdate = findBook(id);
        if(bookToUpdate != null) {
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setBorrowed(book.isBorrowed());
        }
    }

    public void deleteBook(Long id) {
        Book bookToDelete = findBook(id);
        if(bookToDelete != null) {
            books.remove(bookToDelete);
        }
    }

    public Book findBook(Long id) {
        for(Book book : books) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
