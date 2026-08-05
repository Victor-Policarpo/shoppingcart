package victor.policarpo.shoppingcart.repository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import victor.policarpo.shoppingcart.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByName(String name);
    boolean existsByName(String name);
}
