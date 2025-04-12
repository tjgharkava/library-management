package ge.temo.librarymanagement.persistance;

import ge.temo.librarymanagement.model.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("""
    SELECT new ge.temo.librarymanagement.model.BookDTO(
        b.id, b.title, b.author, b.borrowed,
        new ge.temo.librarymanagement.model.UserDTO(u.id, u.name)
    )
    FROM Book b JOIN b.borrower u
""")
    Page<BookDTO> findBooks(Pageable pageable);

}
