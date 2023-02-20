package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeguroRepositorio  extends JpaRepository<Seguro, Long> {

    @Query(value = "Select * from persona c where c.nom_seguro = :nom_seguro", nativeQuery = true)
    public Seguro findBySeguro(String nom_seguro);
}
