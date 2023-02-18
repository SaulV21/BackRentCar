package com.rentcar.BackRentCar.implementos;


import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.repository.AlquilerRepositorio;
import com.rentcar.BackRentCar.service.AlquilerServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AlquilerServiceImpl extends GenericServiceImpl<Alquiler, Integer> implements AlquilerServicio {
    @Autowired
    AlquilerRepositorio alquilerRepositorio;
    @Override
    public CrudRepository<Alquiler, Integer> getDao() {
        return alquilerRepositorio;
    }

    public Alquiler findByAlquiler(Integer id_alquiler){
        return alquilerRepositorio.findByAlquiler(id_alquiler);
    }
}
