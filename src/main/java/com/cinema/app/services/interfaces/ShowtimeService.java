package com.cinema.app.services.interfaces;

import java.util.List;

import com.cinema.app.dto.ShowtimeDTO;

public interface ShowtimeService {
    public List<ShowtimeDTO> getMovieShowtimes(int movieId);
}
