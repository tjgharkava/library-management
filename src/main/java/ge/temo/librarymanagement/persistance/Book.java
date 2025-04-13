package ge.temo.librarymanagement.persistance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq", allocationSize = 1)
@Getter
@Setter
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

}
