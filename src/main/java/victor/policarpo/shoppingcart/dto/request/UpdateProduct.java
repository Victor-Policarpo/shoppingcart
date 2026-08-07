package victor.policarpo.shoppingcart.dto.request;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UpdateProduct(
        @Size(min = 3, max = 100, message = "This field must contain 3 to 100 characters.")
        String name,
        @Size(min = 3, max = 100, message = "This field must contain 3 to 100 characters.")
        String description,
        @PositiveOrZero(message = "This field requires positive number or zero")
        BigDecimal price,
        @PositiveOrZero(message = "This field requires positive number or zero")
        Integer quantityInventory
) {
}
