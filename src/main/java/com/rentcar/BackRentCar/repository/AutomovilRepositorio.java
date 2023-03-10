package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface AutomovilRepositorio extends JpaRepository<Automovil, Long> {
    @Query(value = "Select * from automovil c where c.num_placa = :num_placa", nativeQuery = true)
    public Automovil findByAuto(String num_placa);
}