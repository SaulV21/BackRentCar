package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.RegistrarDanio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistrarDanioRepositorio extends JpaRepository<RegistrarDanio, Long> {

    @Query(value = "Select * from persona c where c.descripcion = :descripcion", nativeQuery = true)
    public RegistrarDanio findByRegistrarDanio(String descripcion);
}
