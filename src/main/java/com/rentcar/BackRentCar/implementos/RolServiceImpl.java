package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.Rol;
import com.rentcar.BackRentCar.repository.RolRepositorio;
import com.rentcar.BackRentCar.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends  GenericServiceImpl<Rol, Long> implements RolService {

    @Autowired
    RolRepositorio rolRepositorio;

    @Override
    public CrudRepository<Rol, Long> getDao() {
        return rolRepositorio;
    }

    public Rol buscarRol(String nombre_Rol) {
        return rolRepositorio.findByRol(nombre_Rol);
    }

}