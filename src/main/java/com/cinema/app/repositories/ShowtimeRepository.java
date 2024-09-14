package com.cinema.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cinema.app.model.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
    public List<Showtime> findByMovieMovieId(int movieId);
}
