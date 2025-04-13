package ge.temo.librarymanagement;

import ge.temo.librarymanagement.model.UserDTO;
import ge.temo.librarymanagement.model.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    Page<UserDTO> getUsers(@RequestParam int page,
                           @RequestParam int size,
                           @RequestParam String name) {
        return userService.getUsers(page, size, name);
    }

    @PostMapping
    ResponseEntity<Void> createUser(@RequestBody @Valid UserRequest request) {
        userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    UserDTO updateUser(@PathVariable Long id, @RequestBody @Valid UserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
