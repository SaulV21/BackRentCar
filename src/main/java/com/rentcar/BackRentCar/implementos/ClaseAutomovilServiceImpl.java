package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.ClaseAutomovil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.rentcar.BackRentCar.service.ClaseAutomovilService;
import com.rentcar.BackRentCar.repository.ClaseAutomovilRepositorio;
@Service
public class ClaseAutomovilServiceImpl extends GenericServiceImpl<ClaseAutomovil, Integer> implements ClaseAutomovilService {

    @Autowired
    ClaseAutomovilRepositorio claseAutomovilRepositorio;

    @Override
    public CrudRepository<ClaseAutomovil, Integer> getDao() {
        return claseAutomovilRepositorio;
    }

    public ClaseAutomovil buscarClaseAutomovil(Integer id_clase) {
        return claseAutomovilRepositorio.findByClaseAuto(id_clase);
    }

}
