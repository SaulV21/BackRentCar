package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {
    @Query(value = "Select * from reserva c where c.cod_reserva = :cod_reserva", nativeQuery = true)
    public Reserva findByReserva(Long cod_reserva);
}
