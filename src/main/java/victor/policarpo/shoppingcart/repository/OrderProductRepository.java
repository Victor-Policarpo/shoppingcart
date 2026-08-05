package victor.policarpo.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.policarpo.shoppingcart.entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
