package com.rentcar.BackRentCar.service;


import com.rentcar.BackRentCar.model.Usuario;

import java.util.List;
import java.util.Optional;



public interface IServicesUsuario {

	Usuario crear(Usuario usuario);

	Optional<Usuario> porId(Long idUsuario);

	List<Usuario> listar();

	Usuario actualizar(Usuario usuario, Long idUsuario);

	boolean eliminar (Long idUsuario);

	Usuario login (String nombreUsuario, String password);

	boolean porUsername(String nombreUsuario);
	Usuario findBynombreUsuarioAndPassword(String nombreUsuario, String password);

	Usuario findBynombreUsuario(String nombreUsuario);

}
