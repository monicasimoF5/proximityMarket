package org.msc.repositories;

import jakarta.validation.Valid;
import org.msc.dtos.FarmerRequest;
import org.msc.dtos.FarmerResponse;
import org.msc.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {

    Optional<Farmer> findByPhone(String phone);

    Optional<Farmer> findById(Long id);

    /*@Query("SELECT f FROM Farmer f WHERE f.name = :name")
    List<Farmer> findFarmerByName(@Param("name") String name);*/

}
