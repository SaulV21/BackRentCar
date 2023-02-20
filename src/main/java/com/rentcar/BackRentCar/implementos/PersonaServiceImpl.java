package com.rentcar.BackRentCar.implementos;

import com.rentcar.BackRentCar.model.Persona;
import com.rentcar.BackRentCar.repository.PersonaRepositorio;
import com.rentcar.BackRentCar.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends  GenericServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepositorio;
    }

    public Persona buscarPersona(String cedula) {
        return personaRepositorio.findByPersona(cedula);
    }

}
