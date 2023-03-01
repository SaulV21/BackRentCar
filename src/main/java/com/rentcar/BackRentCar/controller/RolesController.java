package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Rol;
import com.rentcar.BackRentCar.service.IServiceRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class RolesController {
    @Autowired
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
    }
}