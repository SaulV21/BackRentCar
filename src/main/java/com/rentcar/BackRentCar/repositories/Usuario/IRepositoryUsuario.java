package com.rentcar.BackRentCar.repositories.Usuario;

import com.rentcar.BackRentCar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryUsuario   extends JpaRepository<Usuario, Long> {

	Usuario findBynombreUsuarioAndPassword(String nombreUsuario, String password);

	Usuario findBynombreUsuario(String nombreUsuario);

}
