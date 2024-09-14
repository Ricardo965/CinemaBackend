package com.cinema.app.services.interfaces;

import java.util.List;

import com.cinema.app.dto.ReservationRequestDTO;
import com.cinema.app.dto.ReservationResponseDTO;

public interface ReservationService {
    public ReservationRequestDTO createReservation(ReservationRequestDTO reservationToSave);

    public List<ReservationResponseDTO> showCustomerReservations(int customerId);

    public void cancelReservation(int reservationId);
}
