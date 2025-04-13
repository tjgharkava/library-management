package ge.temo.librarymanagement;

import ge.temo.librarymanagement.error.NotFoundException;
import ge.temo.librarymanagement.model.BookDTO;
import ge.temo.librarymanagement.model.BookRequest;
import ge.temo.librarymanagement.model.UserDTO;
import ge.temo.librarymanagement.persistance.Book;
import ge.temo.librarymanagement.persistance.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserService userService;

    public Page<BookDTO> getBooks(int page, int size) {
        return bookRepository.findBooks(PageRequest.of(page, size));
    }

    public void addBook(BookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setBorrowed(request.isBorrowed());
        book.setBorrower(userService.findUser(request.getUserId()));
        bookRepository.save(book);

    }

    public void updateBook(Long id, BookRequest request) {
        Book book = bookRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setBorrowed(request.isBorrowed());
        if(book.getBorrower().getId() != request.getUserId()) {
            book.setBorrower(userService.findUser(request.getUserId()));
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookDTO findBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        return mapBook(book);
    }

    private BookDTO mapBook(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getBorrowed(),
                new UserDTO(
                        book.getBorrower().getId(),
                        book.getBorrower().getName()));
    }

    private NotFoundException buildNotFoundException(Long id) {
        return new NotFoundException("Book with id " + id + " not found");
    }
}
