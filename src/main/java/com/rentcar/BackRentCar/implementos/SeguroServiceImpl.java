package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.Seguro;
import com.rentcar.BackRentCar.repository.SeguroRepositorio;
import com.rentcar.BackRentCar.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class SeguroServiceImpl extends  GenericServiceImpl<Seguro, Integer> implements SeguroService {

    @Autowired
    SeguroRepositorio seguroRepositorio;

    @Override
    public CrudRepository<Seguro, Integer> getDao() {
        return seguroRepositorio;
    }

    public Seguro buscarSeguro(String nom_seguro) {
        return seguroRepositorio.findBySeguro(nom_seguro);
    }

}
