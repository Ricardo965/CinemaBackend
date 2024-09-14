package com.cinema.app.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationPK implements Serializable {

    @Column(name = "customer_id", insertable = false, updatable = false)
    private int customerId;

    @Column(name = "showtime_id", insertable = false, updatable = false)
    private int showtimeId;
}
