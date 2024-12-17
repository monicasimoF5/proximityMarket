package org.msc.services;

import org.msc.dtos.FarmerRequest;
import org.msc.dtos.FarmerResponse;
import org.msc.entities.Farmer;
import org.msc.repositories.FarmerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;


    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }




}
