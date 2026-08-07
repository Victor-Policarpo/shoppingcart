package victor.policarpo.shoppingcart.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateProduct(
        @NotBlank(message = "This field can't be blank")
        @Size(message = "This field requires a minimum of 3 and a maximum of 30 characters.")
        String name,
        @PositiveOrZero(message = "This field requires positive number or zero")
        Integer quantityInventory,
        @PositiveOrZero(message = "This field requires positive number or zero")
        BigDecimal price,
        @NotBlank(message = "This field can't be blank")
        @Size(message = "This field requires a minimum of 3 and a maximum of 30 characters.")
        String description
) {
}
