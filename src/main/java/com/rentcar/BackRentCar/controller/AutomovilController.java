package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Automovil;
import com.rentcar.BackRentCar.service.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/automovil")
public class AutomovilController {
    @Autowired
    AutomovilService automovilService;
    @GetMapping("/listarauto")
    public ResponseEntity<List<Automovil>> listarAutos() {
        try {
            return new ResponseEntity<>(automovilService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarauto/{num_placa}")
    public ResponseEntity<Automovil> getByPlaca(@PathVariable("num_placa") String num_placa){
        try {
            return  new ResponseEntity<>(automovilService.findById(num_placa), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardarAuto")
    public ResponseEntity<Automovil> createAuto(@RequestBody Automovil alq){
        try {
            return new ResponseEntity<>(automovilService.save(alq), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/borrarAuto/{num_placa}")
    public ResponseEntity<?> deleteauto(@PathVariable("num_placa") String num_placa) {
        try {
            automovilService.delete(num_placa);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el auto");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateauto/{num_placa}")
    public ResponseEntity<Automovil> updateAuto(@RequestBody Automovil prs, @PathVariable("num_placa") String num_placa){
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
