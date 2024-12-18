package org.msc.controllers;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.msc.dtos.FarmerRequest;
import org.msc.dtos.FarmerResponse;
import org.msc.repositories.FarmerRepository;
import org.msc.services.FarmerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmers")
public class FarmerController {
    private final FarmerService farmerService;
    private final FarmerRepository farmerRepository;

    public FarmerController(FarmerService farmerService,
                            FarmerRepository farmerRepository) {
        this.farmerService = farmerService;
        this.farmerRepository = farmerRepository;
    }

    @PostMapping
    public ResponseEntity<FarmerResponse> addFarmer(@RequestBody @Valid FarmerRequest farmerRequest){
        FarmerResponse farmerResponse = farmerService.createFarmer(farmerRequest);
        return new ResponseEntity<>(farmerResponse, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<FarmerResponse>> getAllFarmers(){
        List<FarmerResponse> allFarmers = farmerService.findAll();
        return new ResponseEntity<>(allFarmers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerResponse> getFarmerById(@PathVariable Long id){
        FarmerResponse farmerResponse = farmerService.findById(id);
        return new ResponseEntity<>(farmerResponse, HttpStatus.OK);
    }

    /*@GetMapping("/farmers/name/{name}")
    public List<FarmerResponse> getFarmerByName(@PathVariable String name){
        if (name == null){
            return farmerService.findAll();
        }
        return farmerService.findByName(name);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<FarmerResponse> updateFarmer (@PathVariable Long id, @RequestBody @Valid FarmerRequest farmerRequest){
        FarmerResponse farmerResponse = farmerService.updateFarmerById(id, farmerRequest);
        return new ResponseEntity<>(farmerResponse, HttpStatus.OK);
    }

}
