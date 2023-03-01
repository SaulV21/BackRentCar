package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.RegistrarDanio;
import com.rentcar.BackRentCar.service.RegistrarDanioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/danio")
public class RegistrarDanioController {
    @Autowired
    RegistrarDanioService registrarDanioService;
    @GetMapping("/listarDanio")
    public ResponseEntity<List<RegistrarDanio>> listarDanio() {
        try {
            return new ResponseEntity<>(registrarDanioService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscar/{cod_rgd}")
    public ResponseEntity<RegistrarDanio> getByIdDanio(@PathVariable("cod_rgd") Long cod_rgd){
        try {
            return  new ResponseEntity<>(registrarDanioService.findById(cod_rgd), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardarDan")
    public ResponseEntity<RegistrarDanio> createDanio(@RequestBody RegistrarDanio alq){
        try {
            return new ResponseEntity<>(registrarDanioService.save(alq), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/borrardan/{cod_rgd}")
    public ResponseEntity<?> deletedan(@PathVariable("cod_rgd") Long cod_rgd) {
        try {
            registrarDanioService.delete(cod_rgd);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el daño");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatedan/{cod_rgd}")
    public ResponseEntity<RegistrarDanio> updateDan(@RequestBody RegistrarDanio prs, @PathVariable("cod_rgd") Long cod_rgd){
        RegistrarDanio pe =registrarDanioService.findById(cod_rgd);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setDescripcion(prs.getDescripcion());
                pe.setPrecio(prs.getPrecio());
                return new ResponseEntity<>(registrarDanioService.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
