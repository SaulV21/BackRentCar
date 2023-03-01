package com.rentcar.BackRentCar.implementos;


import com.rentcar.BackRentCar.DAOService.IDAOUsuario;
import com.rentcar.BackRentCar.model.Usuario;
import com.rentcar.BackRentCar.service.IServicesUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceImplUsuario implements IServicesUsuario {

	@Autowired
	private IDAOUsuario dao;

	@Override
	public Usuario crear(Usuario usuario) {

		return dao.crear(usuario);
	}

	@Override
	public Optional<Usuario> porId(Long idUsuario) {

		return dao.porId(idUsuario);
	}

	@Override
	public List<Usuario> listar() {

		return dao.listar();
	}

	@Override
	public Usuario actualizar(Usuario usuario, Long idUsuario) {

	return dao.actualizar(usuario, idUsuario);

	}

	@Override
	public boolean eliminar(Long idUsuario) {

		return dao.eliminar(idUsuario);
	}

	@Override
	public Usuario login(String nombreUsuario, String password) {

		return dao.findBynombreUsuarioAndPassword(nombreUsuario, password);
	}

	@Override
	public boolean porUsername(String nombreUsuario) {

		return dao.porUsername(nombreUsuario);
	}

	@Override
	public Usuario findBynombreUsuarioAndPassword(String nombreUsuario, String password) {
		return dao.findBynombreUsuarioAndPassword(nombreUsuario,password);
	}

	@Override
	public Usuario findBynombreUsuario(String nombreUsuario) {
		return null;
	}

}
