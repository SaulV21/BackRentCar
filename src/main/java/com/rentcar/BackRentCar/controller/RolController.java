package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Rol;
import com.rentcar.BackRentCar.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping("/listarol")
    public ResponseEntity<List<Rol>> listarol() {
        try {
            return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarol/{id_rol}")
    public ResponseEntity<Rol> getByRol(@PathVariable("id_rol") Long id_rol){
        try {
            return  new ResponseEntity<>(rolService.findById(id_rol), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardarol")
    public ResponseEntity<Rol> createRol(@RequestBody Rol alq){
        try {
            return new ResponseEntity<>(rolService.save(alq), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/borrarol/{id_rol}")
    public ResponseEntity<?> deleterol(@PathVariable("id_rol") Long id_rol) {
        try {
            rolService.delete(id_rol);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el rol");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updaterol/{id_rol}")
    public ResponseEntity<Rol> updateAlq(@RequestBody Rol prs, @PathVariable("id_rol") Long id_rol){
        Rol pe =rolService.findById(id_rol);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setNombre_Rol(prs.getNombre_Rol());

                return new ResponseEntity<>(rolService.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
