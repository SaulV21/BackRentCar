package com.rentcar.BackRentCar.controller;

import com.rentcar.BackRentCar.model.Alquiler;
import com.rentcar.BackRentCar.model.Reserva;
import com.rentcar.BackRentCar.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ReservaController {
    @Autowired
    ReservaService reservaService;
    @GetMapping("/listarreserva")
    public ResponseEntity<List<Reserva>> listarReserva() {
        try {
            return new ResponseEntity<>(reservaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscar/{cod_reserva}")
    public ResponseEntity<Reserva> getByIdReserva(@PathVariable("cod_reserva") Long cod_reserva){
        try {
            return  new ResponseEntity<>(reservaService.findById(cod_reserva), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardarReserva")
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva alq){
        try {
            return new ResponseEntity<>(reservaService.save(alq), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/borrarReserva/{cod_reserva}")
    public ResponseEntity<?> deletereserva(@PathVariable("cod_reserva") Long cod_reserva) {
        try {
            reservaService.delete(cod_reserva);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la reserva");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateres/{id_alquiler}")
    public ResponseEntity<Reserva> updateRes(@RequestBody Reserva prs, @PathVariable("cod_reserva") Long cod_reserva){
        Reserva pe =reservaService.findById(cod_reserva);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setForma_pago(prs.getForma_pago());
                pe.setFecha_finresv(prs.getFecha_finresv());
                pe.setFecha_iniresv(prs.getFecha_iniresv());
                pe.setHorareservarealizad(prs.getHorareservarealizad());
                return new ResponseEntity<>(reservaService.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
