package ge.temo.librarymanagement;

import ge.temo.librarymanagement.model.BookDTO;
import ge.temo.librarymanagement.model.BookRequest;
import org.springframework.data.domain.Page;
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
    Page<BookDTO> getBooks(@RequestParam int page, @RequestParam int size) {
        return bookService.getBooks(page, size);
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
    void addBook(@RequestBody BookRequest request) {
        bookService.addBook(request);
    }

    @PutMapping("{id}")
    void updateBook(@PathVariable Long id, @RequestBody BookRequest request) {
        bookService.updateBook(id, request);
    }

    @DeleteMapping("{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
