package com.cinema.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.cinema.app.dto.MovieDTO;
import com.cinema.app.dto.ReservationRequestDTO;
import com.cinema.app.dto.ReservationResponseDTO;
import com.cinema.app.dto.ShowtimeDTO;
import com.cinema.app.services.interfaces.MovieService;
import com.cinema.app.services.interfaces.ReservationService;
import com.cinema.app.services.interfaces.ShowtimeService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/")
public class CinemaController {

    private ReservationService reservationService;
    private MovieService movieService;
    private ShowtimeService showtimeService;

    public CinemaController(ReservationService reservationService, MovieService movieService,
            ShowtimeService showtimeService) {
        this.reservationService = reservationService;
        this.movieService = movieService;
        this.showtimeService = showtimeService;
    }

    @GetMapping("/movies")
    public List<MovieDTO> showAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}")
    public List<ShowtimeDTO> showMovieShowtimes(@PathVariable int movieId) {
        return showtimeService.getMovieShowtimes(movieId);
    }

    @GetMapping("/reservations/{customerId}")
    public List<ReservationResponseDTO> showAllReservations(@PathVariable int customerId) {
        return reservationService.showCustomerReservations(customerId);
    }

    @PostMapping("/reservations")
    public ResponseEntity<ReservationRequestDTO> createReservation(
            @RequestBody ReservationRequestDTO reservationToAddDTO) {
        System.out.println("Entrando a createReservation");
        try {
            ReservationRequestDTO reservation = reservationService.createReservation(reservationToAddDTO);
            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/reservations/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable int reservationId) {
        System.out.println("reservationId: " + reservationId);
        try {
            reservationService.cancelReservation(reservationId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println("salto excepcion");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
