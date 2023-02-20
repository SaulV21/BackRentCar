package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Reserva;
import com.rentcar.BackRentCar.repository.ReservaRepositorio;
import com.rentcar.BackRentCar.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl extends GenericServiceImpl<Reserva, Long> implements ReservaService {
    @Autowired
    ReservaRepositorio reservaRepositorio;
    @Override
    public CrudRepository<Reserva, Long> getDao() {
        return reservaRepositorio;
    }
}
