package org.msc.services;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.msc.dtos.ProductRequest;
import org.msc.dtos.ProductResponse;
import org.msc.entities.Farmer;
import org.msc.entities.Product;
import org.msc.exceptions.MarketNotFoundException;
import org.msc.exceptions.MarketAlreadyExistsException;
import org.msc.mappers.ProductMapper;
import org.msc.repositories.FarmerRepository;
import org.msc.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final FarmerRepository farmerRepository;

    public ProductService(ProductRepository productRepository, FarmerRepository farmerRepository) {
        this.productRepository = productRepository;
        this.farmerRepository = farmerRepository;
    }

    public Object createProduct(ProductRequest productRequest) throws MarketAlreadyExistsException {
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

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Product>> violations = validator.validate(productToSave);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Validation error: " + violations.toString());
        }

        Product saveProduct = productRepository.save(productToSave);
        return ProductMapper.toResponse(saveProduct);

    }

    public List<ProductResponse> listAllProducts(){
            List<Product> productList = productRepository.findAll();
            List<ProductResponse> responseList = new java.util.ArrayList<>(Collections.emptyList());
            productList.forEach(product -> {
                ProductResponse productResponse = ProductMapper.toResponse(product);
                responseList.add(productResponse);
            });

            if(productList.isEmpty()){
                throw new MarketNotFoundException("There are not products to show.");
            }
            return responseList;
    }

    public ProductResponse getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()){
            throw new MarketNotFoundException("Product with id " + id + " does not exist.");
        }

        Product product = optionalProduct.get();
        return ProductMapper.toResponse(product);
    }

    public ProductResponse updateProduct(Long id, ProductRequest productRequest){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();

            product.setName(productRequest.name());
            product.setType(productRequest.type());

            Product updateProduct = productRepository.save(product);
            return ProductMapper.toResponse(updateProduct);
        }
        throw new MarketNotFoundException("The product with id " + id + " does not exist.");
    }

    public void deleteProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()){
            productRepository.deleteById(id);
        } else {
            throw new MarketNotFoundException("The product with id " + id + " does not exist.");
        }
    }





}
