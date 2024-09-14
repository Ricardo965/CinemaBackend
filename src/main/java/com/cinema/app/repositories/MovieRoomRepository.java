package com.cinema.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cinema.app.model.MovieRoom;

public interface MovieRoomRepository extends JpaRepository<MovieRoom, Integer> {

}
