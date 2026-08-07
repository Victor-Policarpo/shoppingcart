package victor.policarpo.shoppingcart.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUser(
        @NotBlank(message = "This field can't be empty")
        @Size(min = 3, max = 30, message = "This field require min 3 and max 30 caracter")
        String name,
        @Email
        String email
) {
}
