package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Persona;
import com.rentcar.BackRentCar.service.PersonaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService per;

    @GetMapping("/listarpersona")
    public ResponseEntity<List<Persona>> getAll() {
        try {
            return new ResponseEntity<>(per.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarpersona/{id_persona}")
    public ResponseEntity<Persona> getById(@PathVariable("id_persona") Long id_persona){
        try {
            return  new ResponseEntity<>(per.findById(id_persona), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardarpersona")
    public ResponseEntity<Persona> create(@RequestBody Persona persona){
        try {
            return new ResponseEntity<>(per.save(persona), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteper/{id_persona}")
    public ResponseEntity<?> deletePerson(@PathVariable("id_persona") Long id_persona) {
        try {
            per.delete(id_persona);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar a la persona");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateper/{id_persona}")
    public ResponseEntity<Persona> updatePerson(@RequestBody Persona prs, @PathVariable("id_persona") Long id_persona){
        Persona pe =per.findById(id_persona);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setNombre(prs.getNombre());
                pe.setApellido(prs.getApellido());
                pe.setCedula(prs.getCedula());
                pe.setDireccion(prs.getDireccion());
                pe.setTelefono(prs.getTelefono());
                pe.setCorreo(prs.getCorreo());
                pe.setEdad(prs.getEdad());
                pe.setCiudad(prs.getCiudad());
                pe.setGenero(prs.getGenero());
                return new ResponseEntity<>(per.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}

