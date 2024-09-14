package com.cinema.app.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.app.dto.ReservationRequestDTO;
import com.cinema.app.dto.ReservationResponseDTO;
import com.cinema.app.model.Customer;
import com.cinema.app.model.Reservation;
import com.cinema.app.model.Showtime;
import com.cinema.app.repositories.CustomerRepository;
import com.cinema.app.repositories.ReservationRepository;
import com.cinema.app.repositories.ShowtimeRepository;
import com.cinema.app.services.interfaces.ReservationService;
import java.util.List;
import java.util.ArrayList;

@Service
public class ReservationServiceImp implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public void cancelReservation(int reservationId) throws RuntimeException {
        if (!reservationRepository.existsById(reservationId)) {
            throw new RuntimeException("Reservation not found");
        }
        reservationRepository.deleteById(reservationId);
    }

    public ReservationRequestDTO createReservation(ReservationRequestDTO reservationDTOToSave) {
        Reservation reservationToSave = convertToReservation(reservationDTOToSave);
        Reservation reservationSaved = reservationRepository.save(reservationToSave);
        return convertToReservationDTO(reservationSaved);
    }

    public List<ReservationResponseDTO> showCustomerReservations(int customerId) {
        List<Reservation> reservations = reservationRepository.findAllByCustomerCustomerId(customerId);
        List<ReservationResponseDTO> reservationResponseDTOs = new ArrayList<>();

        for (Reservation reservation : reservations) {
            ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO();
            reservationResponseDTO.setReservationId(reservation.getReservationId());
            reservationResponseDTO.setCustomerId(reservation.getCustomer().getCustomerId());
            reservationResponseDTO.setShowtimeId(reservation.getShowtime().getShowtimeId());
            reservationResponseDTO.setReservedSeats(reservation.getReservedSeats());
            reservationResponseDTOs.add(reservationResponseDTO);
        }

        return reservationResponseDTOs;
    }

    public Reservation convertToReservation(ReservationRequestDTO reservationDTOToSave) {

        Customer customer = customerRepository.findById(reservationDTOToSave.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Showtime showtime = showtimeRepository.findById(reservationDTOToSave.getShowtimeId())
                .orElseThrow(() -> new RuntimeException("Showtime not found"));

        System.out.println(customer);
        System.out.println(showtime);

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setShowtime(showtime);
        reservation.setReservedSeats(reservationDTOToSave.getReservedSeats());
        return reservation;
    }

    public ReservationRequestDTO convertToReservationDTO(Reservation reservation) {
        ReservationRequestDTO reservationDTO = new ReservationRequestDTO();
        reservationDTO.setCustomerId(reservation.getCustomer().getCustomerId());
        reservationDTO.setShowtimeId(reservation.getShowtime().getShowtimeId());
        reservationDTO.setReservedSeats(reservation.getReservedSeats());
        return reservationDTO;
    }
}
