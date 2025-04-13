package ge.temo.librarymanagement.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequest {
    @NotBlank
    @Size(max = 50)
    private String title;
    @Size(max = 50)
    private String author;
    private boolean borrowed;
    @Positive
    private Long userId;

}
