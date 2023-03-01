package com.rentcar.BackRentCar.repositories.Rol;


import com.rentcar.BackRentCar.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IRepositoryRoles  extends JpaRepository<Rol, Long> {
	@Query(value = "Select * from rol c where c.nombre_rol = :nombre_rol", nativeQuery = true)
	Rol findByNombre(String nombre_rol);
}
