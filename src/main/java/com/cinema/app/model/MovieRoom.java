package com.cinema.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movie_rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomId;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    // Getters and Setters
}
