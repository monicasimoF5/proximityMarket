package org.msc.mappers;

import org.msc.dtos.FarmerResponse;
import org.msc.dtos.ProductRequest;
import org.msc.dtos.ProductResponse;
import org.msc.entities.Farmer;
import org.msc.entities.Product;

public class ProductMapper {
    public static Product toEntity(ProductRequest productRequest, Farmer farmer){
        return new Product(
                productRequest.name(),
                productRequest.type(),
                productRequest.season(),
                productRequest.createdAt(),
                farmer
        );
    }

    public static ProductResponse toResponse(Product product){
        FarmerResponse farmerResponse = FarmerMapper.toResponse(product.getFarmer());
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getType(),
                product.getSeason(),
                product.getCreatedAt(),
                farmerResponse);
    }
}
