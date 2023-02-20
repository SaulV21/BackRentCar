package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.Comprobante;
import com.rentcar.BackRentCar.repository.ComprobanteRepositorio;
import com.rentcar.BackRentCar.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteServiceImpl extends GenericServiceImpl<Comprobante, Long> implements ComprobanteService {

    @Autowired
    ComprobanteRepositorio comprobanteRepositorio;

    @Override
    public CrudRepository<Comprobante, Long> getDao() {

        return comprobanteRepositorio;
    }

    public Comprobante buscarComprobante(String cod_comp) {
        return comprobanteRepositorio.findByComprobante(cod_comp);
    }

}
