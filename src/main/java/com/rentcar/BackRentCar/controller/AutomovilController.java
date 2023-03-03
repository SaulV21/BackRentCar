package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Automovil;
import com.rentcar.BackRentCar.model.ClaseAutomovil;
import com.rentcar.BackRentCar.service.AutomovilService;
import com.rentcar.BackRentCar.service.ClaseAutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/automovil")
public class AutomovilController {
    @Autowired
    AutomovilService automovilService;
    @Autowired
    ClaseAutomovilService claseAuto;
    @GetMapping("/listarauto")
    public ResponseEntity<List<Automovil>> listarAutos() {
        try {
            return new ResponseEntity<>(automovilService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarauto/{num_placa}")
    public ResponseEntity<Automovil> getByPlaca(@PathVariable("idauto") Long num_placa){
        try {
            return  new ResponseEntity<>(automovilService.findById(num_placa), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear/{id_clase}/automoviles")
    public ResponseEntity<Automovil> crear(@PathVariable(value = "id_clase") Long id_clase, @RequestBody Automovil automovil) {
        ClaseAutomovil claseautomovil= claseAuto.findById(id_clase);

        automovil.setClaseAutomovil(claseautomovil);
        Automovil nuevoAutomovil = automovilService.save(automovil);
        return new ResponseEntity<>(nuevoAutomovil, HttpStatus.CREATED);
    }


    @DeleteMapping("/borrarAuto/{idauto}")
    public ResponseEntity<?> deleteauto(@PathVariable("idauto") Long num_placa) {
        try {
            automovilService.delete(num_placa);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el auto");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateauto/{idauto}")
    public ResponseEntity<Automovil> updateAuto(@RequestBody Automovil prs, @PathVariable("num_placa") Long num_placa){
        Automovil pe =automovilService.findById(num_placa);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setAnio(prs.getAnio());
                pe.setColor(prs.getColor());
                pe.setMarca(prs.getMarca());
                pe.setEstado(prs.getEstado());
                pe.setModelo(prs.getModelo());
                pe.setTipo_vehiculo(prs.getTipo_vehiculo());
                return new ResponseEntity<>(automovilService.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
