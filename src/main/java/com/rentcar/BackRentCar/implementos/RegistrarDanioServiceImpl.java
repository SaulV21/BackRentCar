package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.RegistrarDanio;
import com.rentcar.BackRentCar.repository.RegistrarDanioRepositorio;
import com.rentcar.BackRentCar.service.RegistrarDanioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrarDanioServiceImpl extends  GenericServiceImpl<RegistrarDanio, Integer> implements RegistrarDanioService {

    @Autowired
    RegistrarDanioRepositorio registrarDanioRepositorio;

    @Override
    public CrudRepository<RegistrarDanio, Integer> getDao() {
        return registrarDanioRepositorio;
    }

    public RegistrarDanio buscarRegistrarDanio(String descripcion) {
        return registrarDanioRepositorio.findByRegistrarDanio(descripcion);
    }

}
