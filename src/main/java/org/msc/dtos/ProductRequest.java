package org.msc.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.msc.entities.Product;

import java.util.Date;

public record ProductRequest(

        @NotNull(message = "The name can not be null.")
        @NotEmpty(message = "The name can not be empty.")
        String name,

        String type,

        Product.Season season,

        Date createdAt,

        @NotNull(message = "The farmer id can not be null.")
        Long farmerId) {
}
