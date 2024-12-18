package org.msc.dtos;


import jakarta.validation.constraints.*;

public record FarmerRequest(

        @NotNull(message = "The name can not be null.")
        @NotEmpty(message = "The name can not be empty.")
        String name,

        @NotBlank
        @Size(min = 9, max = 9, message = "The phone must be have 9 digits." )
        @Pattern(regexp = "^\\d{9}$", message = "The Phone must be have 9 digits.")
        String phone,

        @NotNull(message = "The email can not be null.")
        @NotEmpty(message = "The email can not be empty.")
        @Email(message = "The email must be a correctly formatted address.")
        String email,

        @NotNull(message = "The address can not be null.")
        @NotEmpty(message = "The address can not be empty.")
        String address
) {
}
