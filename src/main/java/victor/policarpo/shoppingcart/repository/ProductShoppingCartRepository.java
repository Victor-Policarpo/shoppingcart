package victor.policarpo.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.policarpo.shoppingcart.entity.ProductShoppingCart;

public interface ProductShoppingCartRepository extends JpaRepository<ProductShoppingCart, Long> {
}
