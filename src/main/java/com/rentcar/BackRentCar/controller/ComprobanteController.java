package com.rentcar.BackRentCar.controller;
import java.util.List;

import com.rentcar.BackRentCar.model.Comprobante;
import com.rentcar.BackRentCar.service.ComprobanteService;
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
public class ComprobanteController {
    @Autowired
    ComprobanteService compserv;

    @GetMapping("/listarcomprobante")
    public ResponseEntity<List<Comprobante>> listarComp() {
        try {
            return new ResponseEntity<>(compserv.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarcomp/{cod_comp}")
    public ResponseEntity<Comprobante> buscarComp(@PathVariable("cod_comp") Long cod_comp){
        try {
            return  new ResponseEntity<>(compserv.findById(cod_comp), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crearComp")
    public ResponseEntity<Comprobante> guardarcomp(@RequestBody Comprobante comp){
        try {
            return new ResponseEntity<>(compserv.save(comp), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deletecomp/{cod_comp}")
    public ResponseEntity<?> borrarComp(@PathVariable("cod_comp") Long cod_comp) {
        try {
            compserv.delete(cod_comp);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el comprobante");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatecomp/{cod_comp}")
    public ResponseEntity<Comprobante> updateComp(@RequestBody Comprobante compro, @PathVariable("cod_comp") Long cod_comp){
        Comprobante co =compserv.findById(cod_comp);

        if(co == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                co.setDescripcion(compro.getDescripcion());
                co.setPrecio(compro.getPrecio());

                return new ResponseEntity<>(compserv.save(compro), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
