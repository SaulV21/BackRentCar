package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolRepositorio extends JpaRepository<Rol, Integer> {
    @Query(value = "Select * from rol c where c.nombre_Rol = :nombre_Rol", nativeQuery = true)
    public Rol findByRol(String nombre_Rol);
}
