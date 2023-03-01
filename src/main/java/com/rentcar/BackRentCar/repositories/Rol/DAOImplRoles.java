package com.rentcar.BackRentCar.repositories.Rol;


import com.rentcar.BackRentCar.DAOService.IDAORoles;
import com.rentcar.BackRentCar.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;






@Repository
public class DAOImplRoles  implements IDAORoles {

	@Autowired
	private IRepositoryRoles repository;

	@Override
	public Rol crear(Rol rol) {

		return repository.save(rol);
	}

	@Override
	public Optional<Rol> porId(Long id_rol) {

		return repository.findById(id_rol);
	}

	@Override
	public List<Rol> listar() {

		return repository.findAll();
	}

	@Override
	public Rol actualizar(Rol roles, Long id_rol) {

		if (repository.findById(id_rol)!=null) {
			roles.setId_rol(id_rol);
			return repository.save(roles);
		}else {
			return null;
		}

	}

	@Override
	public boolean eliminar(Long id_rol) {

		if (repository.findById(id_rol)!=null) {
			repository.deleteById(id_rol);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Rol porNombre(String nombre_rol) {

		return repository.findByNombre(nombre_rol);
	}

	
	
	
}
