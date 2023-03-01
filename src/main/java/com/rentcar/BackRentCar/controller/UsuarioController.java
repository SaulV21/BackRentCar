package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Usuario;
import com.rentcar.BackRentCar.service.IServicesUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private IServicesUsuario service;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.crear(usuario);
    }

    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Usuario> porId(@PathVariable Long idUsuario){
        return service.porId(idUsuario);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public List<Usuario> listar(){
        return service.listar();
    }

    @RequestMapping(value = "/actualizar/{idUsuario}", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public Usuario modificar(@PathVariable Long idUsuario, @RequestBody Usuario usuario){
        return service.actualizar(usuario, idUsuario);
    }

    @RequestMapping(value = "/eliminar/{idUsuario}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public boolean eliminar(@PathVariable Long idUsuario) {
        return service.eliminar(idUsuario);
    }

    @RequestMapping(value = "login/{nombreUsuario}/{password}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Usuario login(@PathVariable String nombreUsuario, @PathVariable String password){
        return service.login(nombreUsuario, password);
    }


    @RequestMapping(value = "porUsername/{nombreUsuario}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public boolean porUsername(@PathVariable String nombreUsuario){
        return service.porUsername(nombreUsuario);
    }



}
