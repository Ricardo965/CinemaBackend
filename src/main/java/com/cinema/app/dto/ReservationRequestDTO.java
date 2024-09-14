package com.cinema.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {

    private int customerId;
    private int showtimeId;
    private int reservedSeats;

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "customerId=" + customerId +
                ", showtimeId=" + showtimeId +
                ", reservedSeats=" + reservedSeats +
                '}';
    }

}
