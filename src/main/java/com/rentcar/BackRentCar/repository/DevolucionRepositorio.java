package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DevolucionRepositorio   extends JpaRepository<Devolucion, Long> {
    @Query(value = "Select * from devolucion c where c.cod_dv = :cod_dv", nativeQuery = true)
    public Devolucion findByDevolucion(Integer cod_dv);
}
