package org.msc.services;

import org.msc.dtos.FarmerRequest;
import org.msc.dtos.FarmerResponse;
import org.msc.entities.Farmer;
import org.msc.exceptions.FarmerExistingPhoneNumberException;
import org.msc.mappers.FarmerMapper;
import org.msc.repositories.FarmerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;


    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public FarmerResponse createFarmer(FarmerRequest farmerRequest){
        Optional<Farmer> existFarmer = farmerRepository.findByPhone(farmerRequest.phone());
        if (existFarmer.isPresent())
            throw new FarmerExistingPhoneNumberException("Farmer already exist with this phone.");

        Farmer farmer = FarmerMapper.toEntity(farmerRequest);
        Farmer savedFarmer = farmerRepository.save(farmer);
        return FarmerMapper.toResponse(savedFarmer);
    }


}
