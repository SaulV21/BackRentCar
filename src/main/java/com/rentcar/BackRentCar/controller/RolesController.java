package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Rol;
import com.rentcar.BackRentCar.service.IServiceRoles;
import com.rentcar.BackRentCar.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/rol")
public class RolesController {
    @Autowired
    RolService ser;

    @GetMapping("/listarol")
    public ResponseEntity<List<Rol>> listarRol(){
        try {
            return new ResponseEntity<>(ser.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarol/{id_rol}")
    public ResponseEntity<Rol> getByIdRol(@PathVariable("id_rol") Long id_rol){
        try {
            return  new ResponseEntity<>(ser.findById(id_rol), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/guardarol")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol){
        try {
            return new ResponseEntity<>(ser.save(rol), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/borrarol/{id_rol}")
    public ResponseEntity<?> deleterol(@PathVariable("id_rol") Long id_rol) {
        try {
            ser.delete(id_rol);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el rol");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatealq/{id_rol}")
    public ResponseEntity<Rol> updateRol(@RequestBody Rol prs, @PathVariable("id_rol") Long id_rol){
        Rol pe =ser.findById(id_rol);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setNombre_Rol(prs.getNombre_Rol());
                return new ResponseEntity<>(ser.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
    /*@Autowired
    private IServiceRoles servivce;

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Rol crear(@RequestBody Rol roles) { return  servivce.crear(roles); }

    @RequestMapping(value = "/{idRol}" , method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Rol> PorId (@PathVariable Long Idrol){
        return  servivce.porId(Idrol);
    }

    @RequestMapping(value = "/listar" , method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public List<Rol> listar() {
        return  servivce.listar();
    }

    @RequestMapping(value = "actualizar/{idRol}" , method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public Rol modificar (@PathVariable Long Idrol,@RequestBody Rol roles){
        return  servivce.actualizar(roles,Idrol);
    }

    @RequestMapping(value = "eliminar/{idRol}" , method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public Boolean  eliminar (@PathVariable Long Idrol){
        return  servivce.eliminar(Idrol);
    }

    @RequestMapping(value = "byName/{nombre}" , method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Rol  porNombre (@PathVariable String nombre){
        return  servivce.porNombre(nombre);
    }*/
}