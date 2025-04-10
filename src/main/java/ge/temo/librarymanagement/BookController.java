package ge.temo.librarymanagement;

import ge.temo.librarymanagement.model.Book;
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
    List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("{id}")
    ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("{id}")
    ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book bookToUpdate = bookService.findBook(id);
        if (bookToUpdate != null) {
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setBorrowed(book.isBorrowed());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book bookToDelete = bookService.findBook(id);
        if (bookToDelete != null) {
            bookService.deleteBook(id);
            return ResponseEntity.ok(bookToDelete);
        }
        return ResponseEntity.notFound().build();
    }
}
