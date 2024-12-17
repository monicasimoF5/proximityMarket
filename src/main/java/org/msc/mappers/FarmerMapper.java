package org.msc.mappers;

import org.msc.dtos.FarmerRequest;
import org.msc.dtos.FarmerResponse;
import org.msc.entities.Farmer;

public class FarmerMapper {
    public static Farmer toEntity(FarmerRequest farmerRequest) {
        return new Farmer(
                farmerRequest.name(),
                farmerRequest.phone(),
                farmerRequest.email(),
                farmerRequest.address());
    }

    public static FarmerResponse toResponse(Farmer farmer){
        return new FarmerResponse(
                farmer.getId(),
                farmer.getName(),
                farmer.getPhone(),
                farmer.getEmail(),
                farmer.getAddress());

    }


}
