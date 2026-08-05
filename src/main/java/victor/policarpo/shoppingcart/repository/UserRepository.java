package victor.policarpo.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.policarpo.shoppingcart.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
