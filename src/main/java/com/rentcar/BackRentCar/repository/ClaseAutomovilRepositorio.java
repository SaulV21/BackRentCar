package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.ClaseAutomovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClaseAutomovilRepositorio   extends JpaRepository<ClaseAutomovil, Integer> {
    @Query(value = "Select * from claseautomovil c where c.nombre = :nombre", nativeQuery = true)
    public ClaseAutomovil findByClaseAuto(Integer nombre);
}
