package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Comprobante;
import com.rentcar.BackRentCar.model.Devolucion;
import com.rentcar.BackRentCar.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class DevolucionController {
    @Autowired
    DevolucionService devolucionService;
    @GetMapping("/listardev")
    public ResponseEntity<List<Devolucion>> listarDev() {
        try {
            return new ResponseEntity<>(devolucionService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscardev/{cod_dv}")
    public ResponseEntity<Devolucion> buscarDev(@PathVariable("cod_dv") Long cod_dv){
        try {
            return  new ResponseEntity<>(devolucionService.findById(cod_dv), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crearDev")
    public ResponseEntity<Devolucion> guardardev(@RequestBody Devolucion comp){
        try {
            return new ResponseEntity<>(devolucionService.save(comp), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deletedev/{cod_dv}")
    public ResponseEntity<?> borrarDev(@PathVariable("cod_dv") Long cod_dv) {
        try {
            devolucionService.delete(cod_dv);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la devolucion");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatedev/{cod_dv}")
    public ResponseEntity<Devolucion> updateDev(@RequestBody Devolucion compro, @PathVariable("cod_dv") Long cod_dv){
        Devolucion co =devolucionService.findById(cod_dv);

        if(co == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                co.setFecha_dv(compro.getFecha_dv());
                co.setLugar_dv(compro.getLugar_dv());

                return new ResponseEntity<>(devolucionService.save(compro), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
