package victor.policarpo.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.policarpo.shoppingcart.entity.Coupons;

public interface CouponsRepository extends JpaRepository<Coupons, Long> {
}
