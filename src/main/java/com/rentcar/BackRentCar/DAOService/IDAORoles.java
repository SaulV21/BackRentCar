package com.rentcar.BackRentCar.DAOService;


import com.rentcar.BackRentCar.model.Rol;

import java.util.List;
import java.util.Optional;



public interface IDAORoles {
	Rol crear(Rol roles);

	Optional<Rol> porId(Long id_rol);

	List<Rol> listar();

	Rol actualizar(Rol roles, Long id_rol);

	boolean eliminar(Long id_rol);

	Rol porNombre(String nombre_rol);
}
