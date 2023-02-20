package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    @Query(value = "Select * from usuario c where c.id_usuario = :id_usuario", nativeQuery = true)
    public Alquiler findByUsuario(Long id_usuario);
}
