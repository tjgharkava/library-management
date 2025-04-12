package ge.temo.librarymanagement;

import ge.temo.librarymanagement.model.UserDTO;
import ge.temo.librarymanagement.model.UserRequest;
import ge.temo.librarymanagement.persistance.User;
import ge.temo.librarymanagement.persistance.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers(int page, int size, String name) {
        return userRepository.findUsers(
                name, PageRequest.of(page, size)
        ).stream().map(this::mapUser).collect(Collectors.toList());
    }

    public void createUser(UserRequest userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        userRepository.save(user);
    }

    public UserDTO updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).get();
        user.setName(request.getName());
        userRepository.save(user);

        return mapUser(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapUser(User user) {
        return new UserDTO(
                user.getId(),
                user.getName()
                );
    }
}
