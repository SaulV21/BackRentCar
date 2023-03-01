package com.rentcar.BackRentCar.repositories.Usuario;


import com.rentcar.BackRentCar.DAOService.IDAOUsuario;
import com.rentcar.BackRentCar.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;




@Repository
public class DAOImplUsuario  implements IDAOUsuario {

	@Autowired
	private IRepositoryUsuario repository;

	@Override
	public Usuario crear(Usuario usuario) {

		return repository.save(usuario);
	}

	@Override
	public Optional<Usuario> porId(Long idUsuario) {
		return repository.findById(idUsuario);
	}

	@Override
	public List<Usuario> listar() {

		return repository.findAll();
	}

	@Override
	public Usuario actualizar(Usuario usuario, Long idUsuario) {

		if(repository.findById(idUsuario)!=null) {
			usuario.setId(idUsuario);
			return repository.save(usuario);
		}else {
			return null;
		}

	}

	@Override
	public boolean eliminar(Long idUsuario) {
		if(repository.findById(idUsuario)!=null) {
			repository.deleteById(idUsuario);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Usuario login(String nombreUsuario, String password) {


		return repository.findBynombreUsuarioAndPassword(nombreUsuario, password);
	}

	@Override
	public boolean porUsername(String nombreUsuario) {

		/*
		if (repository.findByUsername(nombreUsuario)!=null) {
			return true;
		}else {
			return false;
		}
		*/
		return false;

	}

	@Override
	public Usuario findBynombreUsuarioAndPassword(String nombreUsuario, String password) {
		return repository.findBynombreUsuarioAndPassword(nombreUsuario,password);
	}

	@Override
	public Usuario findBynombreUsuario(String nombreUsuario) {
		return null;
	}


}
