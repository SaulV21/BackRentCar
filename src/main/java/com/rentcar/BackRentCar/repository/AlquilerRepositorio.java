package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlquilerRepositorio  extends JpaRepository<Alquiler, Long> {
    @Query(value = "Select * from alquiler c where c.id_alquiler = :id_alquiler", nativeQuery = true)
    public Alquiler findByAlquiler(Long id_alquiler);
}
