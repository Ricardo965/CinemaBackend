package com.cinema.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cinema.app.model.Customer;
import com.cinema.app.model.Movie;
import com.cinema.app.model.MovieRoom;
import com.cinema.app.model.Showtime;
import com.cinema.app.repositories.CustomerRepository;
import com.cinema.app.repositories.MovieRepository;
import com.cinema.app.repositories.MovieRoomRepository;
import com.cinema.app.repositories.ShowtimeRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieRoomRepository movieRoomRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @PostConstruct
    public void init() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Ricardo");
        customer.setLastName("García");
        customer.setEmail("email@gmail.com");
        customer.setPassword("password");
        customer.setBirthDate(LocalDate.of(2005, 3, 18));
        customer.setJoinDate(LocalDate.now());

        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setTitle("Inception");
        movie.setDirector("Christopher Nolan");
        movie.setDuration(148);
        movie.setReleaseDate(LocalDate.of(2015, 3, 18));

        Movie movie1 = new Movie();
        movie1.setMovieId(2);
        movie1.setTitle("The Matrix");
        movie1.setDirector("The Wachowskis");
        movie1.setDuration(136);
        movie1.setReleaseDate(LocalDate.of(1999, 3, 31));

        Movie movie2 = new Movie();
        movie2.setMovieId(3);
        movie2.setTitle("The Shawshank Redemption");
        movie2.setDirector("Frank Darabont");
        movie2.setDuration(142);
        movie2.setReleaseDate(LocalDate.of(1994, 9, 23));

        Movie movie3 = new Movie();
        movie3.setMovieId(4);
        movie3.setTitle("Interstellar");
        movie3.setDirector("Christopher Nolan");
        movie3.setDuration(169);
        movie3.setReleaseDate(LocalDate.of(2014, 11, 7));

        MovieRoom movieRoom = new MovieRoom();
        movieRoom.setRoomId(1);
        movieRoom.setRoomNumber("A1");
        movieRoom.setCapacity(200);

        Showtime showtime = new Showtime();
        showtime.setShowtimeId(1);
        showtime.setMovie(movie);
        showtime.setMovieRoom(movieRoom);
        showtime.setStartTime(LocalDateTime.of(2024, 9, 18, 10, 0));

        Showtime showtime1 = new Showtime();
        showtime1.setShowtimeId(2);
        showtime1.setMovie(movie1);
        showtime1.setMovieRoom(movieRoom);
        showtime1.setStartTime(LocalDateTime.of(2024, 3, 16, 22, 0));

        Showtime showtime2 = new Showtime();
        showtime2.setShowtimeId(3);
        showtime2.setMovie(movie2);
        showtime2.setMovieRoom(movieRoom);
        showtime2.setStartTime(LocalDateTime.of(2024, 3, 16, 12, 0));

        Showtime showtime3 = new Showtime();
        showtime3.setShowtimeId(4);
        showtime3.setMovie(movie3);
        showtime3.setMovieRoom(movieRoom);
        showtime3.setStartTime(LocalDateTime.of(2024, 3, 16, 22, 30));

        customerRepository.save(customer);
        movieRepository.save(movie);
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRoomRepository.save(movieRoom);
        showtimeRepository.save(showtime);
        showtimeRepository.save(showtime1);
        showtimeRepository.save(showtime2);
        showtimeRepository.save(showtime3);

    }
}
