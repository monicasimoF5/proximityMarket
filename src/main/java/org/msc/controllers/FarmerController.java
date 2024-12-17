package org.msc.controllers;

import jakarta.validation.Valid;
import org.msc.dtos.FarmerRequest;
import org.msc.dtos.FarmerResponse;
import org.msc.services.FarmerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmers")
public class FarmerController {
    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping
    public ResponseEntity<FarmerResponse> addFarmer(@RequestBody @Valid FarmerRequest farmerRequest){
        FarmerResponse farmerResponse = farmerService.createFarmer(farmerRequest);
        return new ResponseEntity<>(farmerResponse, HttpStatus.CREATED);
    }

}
