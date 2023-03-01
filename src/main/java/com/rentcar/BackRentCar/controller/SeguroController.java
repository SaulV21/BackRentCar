package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Seguro;
import com.rentcar.BackRentCar.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/seguro")
public class SeguroController {
    @Autowired
    SeguroService seguroService;
    @GetMapping("/listarseguro")
    public ResponseEntity<List<Seguro>> listarseguro() {
        try {
            return new ResponseEntity<>(seguroService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarseg/{cod_seguro}")
    public ResponseEntity<Seguro> getByIdSeguro(@PathVariable("cod_seguro") Long cod_seguro){
        try {
            return  new ResponseEntity<>(seguroService.findById(cod_seguro), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardarSeguro")
    public ResponseEntity<Seguro> createSeguro(@RequestBody Seguro alq){
        try {
            return new ResponseEntity<>(seguroService.save(alq), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/borrarSeguro/{cod_seguro}")
    public ResponseEntity<?> deleteSeguro(@PathVariable("cod_seguro") Long cod_seguro) {
        try {
            seguroService.delete(cod_seguro);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el seguro");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateseg/{cod_seguro}")
    public ResponseEntity<Seguro> updateSeg(@RequestBody Seguro prs, @PathVariable("cod_seguro") Long cod_seguro){
        Seguro pe =seguroService.findById(cod_seguro);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setNom_seguro(prs.getNom_seguro());
                pe.setPrecio_seguro(prs.getPrecio_seguro());
                return new ResponseEntity<>(seguroService.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
