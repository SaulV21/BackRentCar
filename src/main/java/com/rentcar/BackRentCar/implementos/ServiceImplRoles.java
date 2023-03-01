package com.rentcar.BackRentCar.implementos;


import com.rentcar.BackRentCar.DAOService.IDAORoles;
import com.rentcar.BackRentCar.model.Rol;
import com.rentcar.BackRentCar.service.IServiceRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceImplRoles  implements IServiceRoles
{


	@Autowired
	private IDAORoles dao;

	@Override
	public Rol crear(Rol roles) {
		
		return dao.crear(roles);
	}

	@Override
	public Optional<Rol> porId(Long id_rol) {
		
		return dao.porId(id_rol);
	}

	@Override
	public List<Rol> listar() {
		return dao.listar();
	}

	@Override
	public Rol actualizar(Rol rol, Long id_rol) {
		return dao.actualizar(rol, id_rol);
	}

	@Override
	public boolean eliminar(Long id_rol) {
		
		return dao.eliminar(id_rol);
	}

	@Override
	public Rol porNombre(String nombre_rol) {
		
		return dao.porNombre(nombre_rol);
	}

	
}
