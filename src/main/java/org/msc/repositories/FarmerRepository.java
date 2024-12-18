package org.msc.repositories;

import org.msc.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {

    Optional<Farmer> findByPhone(String phone);

    Optional<Farmer> findById(Long id);

    List<Farmer> findFarmerByName(String name);


}
