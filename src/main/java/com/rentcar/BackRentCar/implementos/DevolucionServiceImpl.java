package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.Devolucion;
import com.rentcar.BackRentCar.repository.DevolucionRepositorio;
import com.rentcar.BackRentCar.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DevolucionServiceImpl extends GenericServiceImpl<Devolucion, Long> implements DevolucionService {
    @Autowired
    DevolucionRepositorio devolucionRepositorio;
    @Override
    public CrudRepository<Devolucion, Long> getDao() {
        return devolucionRepositorio;
    }
}
