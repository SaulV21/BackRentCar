package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.ClaseAutomovil;
import com.rentcar.BackRentCar.service.ClaseAutomovilService;
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
@RequestMapping("/api")
public class ClaseAutomovilController {
    @Autowired
    ClaseAutomovilService claseautomovil;

    @GetMapping("/listarclase")
    public ResponseEntity<List<ClaseAutomovil>> getAll() {
        try {
            return new ResponseEntity<>(claseautomovil.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarclase/{id_clase}")
    public ResponseEntity<ClaseAutomovil> getById(@PathVariable("id_clase") Long id_clase){
        try {
            return  new ResponseEntity<>(claseautomovil.findById(id_clase), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crearclase")
    public ResponseEntity<ClaseAutomovil> createReproducion(@RequestBody ClaseAutomovil claseauto){
        try {
            return new ResponseEntity<>(claseautomovil.save(claseauto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/borrarclase/{id_clase}")
    public ResponseEntity<?> delete(@PathVariable("id_clase") Long id_clase) {
        try {
            claseautomovil.delete(id_clase);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar La clase automovil");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateclase/{id_clase}")
    public ResponseEntity<ClaseAutomovil> updateClient(@RequestBody ClaseAutomovil clauto, @PathVariable("id_clase") Long id_clase){
        ClaseAutomovil ca =claseautomovil.findById(id_clase);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setNombre(clauto.getNombre());
                ca.setPrecio_alquiler_dia(clauto.getPrecio_alquiler_dia());


                return new ResponseEntity<>(claseautomovil.save(clauto), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
