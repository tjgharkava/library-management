package ge.temo.librarymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private boolean borrowed;
    private UserDTO borrower;

}
