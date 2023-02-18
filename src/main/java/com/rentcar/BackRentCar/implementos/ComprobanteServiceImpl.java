package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.Comprobante;
import com.rentcar.BackRentCar.repository.ComprobanteRepositorio;
import com.rentcar.BackRentCar.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteServiceImpl extends GenericServiceImpl<Comprobante, Integer> implements ComprobanteService {

    @Autowired
    ComprobanteRepositorio comprobanteRepositorio;

    @Override
    public CrudRepository<Comprobante, Integer> getDao() {

        return comprobanteRepositorio;
    }

    public Comprobante buscarComprobante(Integer cod_comp) {
        return comprobanteRepositorio.findByComprobante(cod_comp);
    }

}
