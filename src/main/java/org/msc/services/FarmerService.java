package org.msc.services;

import org.msc.dtos.FarmerRequest;
import org.msc.dtos.FarmerResponse;
import org.msc.entities.Farmer;
import org.msc.exceptions.FarmerExistingPhoneException;
import org.msc.exceptions.FarmerNotFoundException;
import org.msc.mappers.FarmerMapper;
import org.msc.repositories.FarmerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
            throw new FarmerExistingPhoneException("Farmer already exist with this phone.");

        Farmer farmer = FarmerMapper.toEntity(farmerRequest);
        Farmer savedFarmer = farmerRepository.save(farmer);
        return FarmerMapper.toResponse(savedFarmer);
    }

    public List<FarmerResponse> findAll(){
        List<Farmer> farmerList= farmerRepository.findAll();
        return farmerList.stream()
                .map(FarmerMapper::toResponse).toList();
    }

    public FarmerResponse findById(Long id){
        Optional<Farmer> optionalFarmer = farmerRepository.findById(id);

        if (optionalFarmer.isPresent()){
            Farmer farmer = optionalFarmer.get();
            return FarmerMapper.toResponse(farmer);
        }
        throw new FarmerNotFoundException("The farmer with id " + id + " does not exists.");
    }

    /*public List<FarmerResponse> findByName (String name){
        List<Farmer> farmers = farmerRepository.findFarmerByName(name);

        return farmers.stream()
                .map(FarmerMapper::toResponse).toList();
    }*/

    public FarmerResponse updateFarmerById(Long id, FarmerRequest farmerRequest){
        Optional<Farmer> optionalFarmer = farmerRepository.findById(id);

        if (optionalFarmer.isPresent()){
            Farmer farmer = optionalFarmer.get();

            farmer.setName(farmerRequest.name());
            farmer.setPhone(farmerRequest.phone());
            farmer.setEmail(farmerRequest.email());
            farmer.setAddress(farmerRequest.address());

            Farmer updatedFarmer = farmerRepository.save(farmer);
            return FarmerMapper.toResponse(updatedFarmer);
        }
        throw new FarmerNotFoundException("The farmer with id " + id + " does not exists.");
    }

public void deleteFramerById(Long id){
    Optional<Farmer> optionalFarmer = farmerRepository.findById(id);

    if(optionalFarmer.isEmpty()){
        throw new FarmerNotFoundException("The farmer with id " + id + " does not exists.");
    }
    farmerRepository.deleteById(id);
}


}
