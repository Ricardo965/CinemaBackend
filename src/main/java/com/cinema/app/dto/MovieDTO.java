package com.cinema.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MovieDTO {
    private int movieId;
    private String title;
    private String director;
    private int duration;
    private LocalDate releaseDate;
}
