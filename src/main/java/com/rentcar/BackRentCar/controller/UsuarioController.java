package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Usuario;
import com.rentcar.BackRentCar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @GetMapping("/listaruser")
    public ResponseEntity<List<Usuario>> listarusuario() {
        try {
            return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscaruser/{id}")
    public ResponseEntity<Usuario> getByIduser(@PathVariable("id") Long id){
        try {
            return  new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardarUser")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario alq){
        try {
            return new ResponseEntity<>(usuarioService.save(alq), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/borraruser/{id}")
    public ResponseEntity<?> deleteauser(@PathVariable("id") Long id) {
        try {
            usuarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el usuario");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario prs, @PathVariable("id") Long id){
        Usuario pe =usuarioService.findById(id);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setNombreUsuario(prs.getNombreUsuario());
                pe.setPassword(prs.getPassword());
                pe.setEmail(prs.getEmail());
                return new ResponseEntity<>(usuarioService.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
