package com.cinema.app.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.app.dto.MovieDTO;
import com.cinema.app.dto.ShowtimeDTO;
import com.cinema.app.model.Movie;
import com.cinema.app.model.Showtime;
import com.cinema.app.repositories.ShowtimeRepository;
import com.cinema.app.services.interfaces.ShowtimeService;

@Service
public class ShowtimeServiceImp implements ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<ShowtimeDTO> getMovieShowtimes(int movieId) {
        List<Showtime> showtimes = showtimeRepository.findByMovieMovieId(movieId);
        List<ShowtimeDTO> showtimeDTOs = new ArrayList<>();
        for (Showtime showtime : showtimes) {
            showtimeDTOs.add(convertToShowtimeDTO(showtime));
        }
        return showtimeDTOs;
    }

    public MovieDTO convertToMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movie.getMovieId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setDuration(movie.getDuration());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        return movieDTO;
    }

    public ShowtimeDTO convertToShowtimeDTO(Showtime showtime) {
        ShowtimeDTO showtimeDTO = new ShowtimeDTO();
        showtimeDTO.setShowtimeId(showtime.getShowtimeId());
        showtimeDTO.setMovie(convertToMovieDTO(showtime.getMovie()));
        showtimeDTO.setMovieRoomNumber(showtime.getMovieRoom().getRoomNumber());
        showtimeDTO.setStartTime(showtime.getStartTime());
        return showtimeDTO;
    }

}
