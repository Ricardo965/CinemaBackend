package com.cinema.app.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShowtimeDTO {
    private int showtimeId;
    private MovieDTO movie;
    private String movieRoomNumber;
    private LocalDateTime startTime;
}
