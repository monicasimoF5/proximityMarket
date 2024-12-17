package org.msc.controllers;

import jakarta.validation.Valid;
import org.msc.dtos.FarmerRequest;
import org.msc.dtos.FarmerResponse;
import org.msc.services.FarmerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<FarmerResponse>> getAllPets(){
        List<FarmerResponse> allFarmers = farmerService.findAll();
        return new ResponseEntity<>(allFarmers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerResponse> getFarmerById(@PathVariable Long id){
        FarmerResponse farmerResponse = farmerService.findById(id);
        return new ResponseEntity<>(farmerResponse, HttpStatus.OK);
    }

}
