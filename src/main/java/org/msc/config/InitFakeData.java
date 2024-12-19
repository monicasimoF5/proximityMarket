package org.msc.config;

import org.hibernate.grammars.hql.HqlParser;
import org.msc.dtos.ProductRequest;
import org.msc.entities.Farmer;
import org.msc.entities.Product;
import org.msc.mappers.ProductMapper;
import org.msc.repositories.FarmerRepository;
import org.msc.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.*;
import java.util.Date;
import java.util.List;

@Configuration
@Profile("!test")
public class InitFakeData {

    @Bean
    public CommandLineRunner initFarmerData (FarmerRepository farmerRepository){
        return args -> {
            if (farmerRepository.count() == 0){
                List<Farmer> farmerList = List.of(
                        new Farmer("farmer1", "123456789", "farmer1@market.com", "address1"),
                        new Farmer("farmer2", "999999999", "farmer2@market.com", "address2")
                );
                farmerRepository.saveAll(farmerList);
            }
        };
    }

    @Bean
    public CommandLineRunner initProductData (ProductRepository productRepository,
                                              FarmerRepository farmerRepository){
        return args -> {
            if (productRepository.count() == 0){

                List<Product> productList = List.of(
                        new Product(
                                "product1",
                                "type1",
                                Product.Season.SUMMER,
                                Date.from(LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 0))
                                    .atZone(ZoneId.systemDefault())
                                    .toInstant()),
                                farmerRepository.findById(1L).orElseThrow()),
                        new Product(
                                "product2",
                                "type2",
                                Product.Season.SPRING,
                                Date.from(LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0))
                                    .atZone(ZoneId.systemDefault())
                                    .toInstant()),
                                farmerRepository.findById(2L).orElseThrow())
                );
                productRepository.saveAll(productList);
            }
        };
    }
}
