package com.cinema.app.services.imp;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.app.dto.MovieDTO;
import com.cinema.app.model.Movie;
import com.cinema.app.repositories.MovieRepository;
import com.cinema.app.services.interfaces.MovieService;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> movieDTOs = new ArrayList<>();

        for (Movie movie : movies) {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setMovieId(movie.getMovieId());
            movieDTO.setTitle(movie.getTitle());
            movieDTO.setDirector(movie.getDirector());
            movieDTO.setDuration(movie.getDuration());
            movieDTO.setReleaseDate(movie.getReleaseDate());
            movieDTOs.add(movieDTO);
        }

        return movieDTOs;

    }
}
