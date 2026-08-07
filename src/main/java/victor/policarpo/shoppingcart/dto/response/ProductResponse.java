package victor.policarpo.shoppingcart.dto.response;

import java.math.BigDecimal;

public record ProductResponse(
        String name,
        Integer quantityInventory,
        BigDecimal price,
        String description
) {
}
