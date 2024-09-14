package com.cinema.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cinema.app.model.Reservation;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    public List<Reservation> findAllByCustomerCustomerId(Integer customer);
}
