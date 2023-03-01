package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Persona;
import com.rentcar.BackRentCar.repository.AlquilerRepositorio;
import com.rentcar.BackRentCar.service.AlquilerServicio;
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

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/alquiler")
public class AlquilerController {
    @Autowired
    AlquilerServicio alquiserv;

    @GetMapping("/listaralquiler")
    public ResponseEntity<List<Alquiler>> listarAlquiler() {
        try {
            return new ResponseEntity<>(alquiserv.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscar/{id_alquiler}")
    public ResponseEntity<Alquiler> getByIdAlquiler(@PathVariable("id_alquiler") Long id_alquiler){
        try {
            return  new ResponseEntity<>(alquiserv.findById(id_alquiler), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardarAlquiler")
    public ResponseEntity<Alquiler> createAlquiler(@RequestBody Alquiler alq){
        try {
            return new ResponseEntity<>(alquiserv.save(alq), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/borrarAlquiler/{id_alquiler}")
    public ResponseEntity<?> deletealquiler(@PathVariable("id_alquiler") Long id_alquiler) {
        try {
            alquiserv.delete(id_alquiler);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el alquiler");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatealq/{id_alquiler}")
    public ResponseEntity<Alquiler> updateAlq(@RequestBody Alquiler prs, @PathVariable("id_alquiler") Long id_alquiler){
        Alquiler pe =alquiserv.findById(id_alquiler);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setFecha_salida(prs.getFecha_salida());
                pe.setDocumento_garantia(prs.getDocumento_garantia());
                pe.setNum_dias_alquiler(prs.getNum_dias_alquiler());
                pe.setProx_fecha_entrega(prs.getProx_fecha_entrega());
                return new ResponseEntity<>(alquiserv.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
