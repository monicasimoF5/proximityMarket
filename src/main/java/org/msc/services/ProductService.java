package org.msc.services;

import org.msc.dtos.ProductRequest;
import org.msc.dtos.ProductResponse;
import org.msc.entities.Farmer;
import org.msc.entities.Product;
import org.msc.exceptions.MarketNotFoundException;
import org.msc.exceptions.MarketAlreadyExistsException;
import org.msc.mappers.ProductMapper;
import org.msc.repositories.FarmerRepository;
import org.msc.repositories.ProductRepository;

import java.util.Optional;

public class ProductService {

    private final ProductRepository productRepository;
    private final FarmerRepository farmerRepository;

    public ProductService(ProductRepository productRepository, FarmerRepository farmerRepository) {
        this.productRepository = productRepository;
        this.farmerRepository = farmerRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest) throws MarketAlreadyExistsException {
        Optional<Product> existProduct = productRepository.findByNameAndFarmerId(productRequest.name(), productRequest.farmerId());
        if (existProduct.isPresent()){
            throw new MarketAlreadyExistsException("There is already a product with this name linked to this farmer");
        }

        Optional<Farmer> existFarmer = farmerRepository.findById(productRequest.farmerId());
        if (existFarmer.isEmpty()){
            throw new MarketNotFoundException("There is no farmer with this id.");
        }

        Farmer farmer = existFarmer.get();
        Product productToSave = ProductMapper.toEntity(productRequest, farmer);
        Product saveProduct = productRepository.save(productToSave);
        return ProductMapper.toResponse(saveProduct);

    }
}
