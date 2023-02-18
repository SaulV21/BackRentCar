package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {
    @Query(value = "Select * from reserva c where c.cod_resv = :cod_resv", nativeQuery = true)
    public Reserva findByReserva(Integer cod_resv);
}
