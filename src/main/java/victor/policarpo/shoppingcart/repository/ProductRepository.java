package victor.policarpo.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.policarpo.shoppingcart.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    boolean existsByName(String name);
}
