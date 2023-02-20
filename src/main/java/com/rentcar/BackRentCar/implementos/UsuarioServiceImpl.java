package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.Usuario;
import com.rentcar.BackRentCar.repository.UsuarioRepositorio;
import com.rentcar.BackRentCar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Override
    public CrudRepository<Usuario, Long> getDao() {
        return usuarioRepositorio;
    }
}
