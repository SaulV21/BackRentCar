package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.Automovil;
import com.rentcar.BackRentCar.model.ClaseAutomovil;
import com.rentcar.BackRentCar.repository.AutomovilRepositorio;
import com.rentcar.BackRentCar.service.AutomovilService;
import com.rentcar.BackRentCar.repository.ClaseAutomovilRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class AutomovilServiceImpl extends GenericServiceImpl<Automovil, Long> implements AutomovilService {

    @Autowired
    AutomovilRepositorio automovilRepositorio;


    @Override
    public CrudRepository<Automovil, Long> getDao() {
        return automovilRepositorio;
    }

    public Automovil buscarAutomovil(String num_placa) {
        return automovilRepositorio.findByAuto(num_placa);
    }
}