package com.cinema.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cinema.app.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
