package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ComprobanteRepositorio extends JpaRepository<Comprobante, Integer>, CrudRepository<Comprobante, Integer> {
    @Query(value = "Select * from comprobante c where c.descripcion = :descripcion", nativeQuery = true)
    public Comprobante findByComprobante(Integer descripcion);
}