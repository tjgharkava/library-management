package ge.temo.librarymanagement;

import ge.temo.librarymanagement.model.BookDTO;
import ge.temo.librarymanagement.model.UserDTO;
import ge.temo.librarymanagement.persistance.Book;
import ge.temo.librarymanagement.persistance.BookRepository;
import ge.temo.librarymanagement.persistance.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<BookDTO> getBooks() {
        return bookRepository.findAll().stream().map(this::mapBook).collect(Collectors.toList());
    }

    public void addBook(BookDTO book) {

    }

    public void updateBook(Long id, BookDTO book) {

    }

    public void deleteBook(Long id) {

    }

    public BookDTO findBook(Long id) {
        Book book = bookRepository.findById(id).get();
        return mapBook(book);
    }

    private BookDTO mapBook(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getBorrowed(),
                new UserDTO(
                        book.getBorrower().getId(),
                        book.getBorrower().getName()));
    }
}
