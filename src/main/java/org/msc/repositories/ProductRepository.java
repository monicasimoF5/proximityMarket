package org.msc.repositories;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.msc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameAndFarmerId(@NotNull(message = "The name can not be null.") @NotEmpty(message = "The name can not be empty.") String name, @NotNull(message = "The farmer id can not be null.") Long farmerId);
}
