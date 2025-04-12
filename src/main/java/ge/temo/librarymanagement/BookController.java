package ge.temo.librarymanagement;

import ge.temo.librarymanagement.model.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("{id}")
    ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
        BookDTO book = bookService.findBook(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    void addBook(@RequestBody BookDTO book) {
        bookService.addBook(book);
    }

    @PutMapping("{id}")
    ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO book) {
        BookDTO bookToUpdate = bookService.findBook(id);
        if (bookToUpdate != null) {
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setBorrowed(book.isBorrowed());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<BookDTO> deleteBook(@PathVariable Long id) {
        BookDTO bookToDelete = bookService.findBook(id);
        if (bookToDelete != null) {
            bookService.deleteBook(id);
            return ResponseEntity.ok(bookToDelete);
        }
        return ResponseEntity.notFound().build();
    }
}
