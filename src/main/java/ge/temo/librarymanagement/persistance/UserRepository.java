package ge.temo.librarymanagement.persistance;

import ge.temo.librarymanagement.model.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT NEW ge.temo.librarymanagement.model.UserDTO(u.id, u.name)" +
            " FROM User u WHERE u.name = :name")
    Page<UserDTO> findUsers(String name, Pageable pageable);

}
