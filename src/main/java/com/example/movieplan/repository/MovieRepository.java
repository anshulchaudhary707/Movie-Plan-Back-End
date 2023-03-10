package com.example.movieplan.repository;

import com.example.movieplan.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie,Long> {
    @Query("Select m From Movie m Where m.disable = true")
    List<Movie> getAllDisabledMovies();
    @Query("Select m From Movie m Where m.disable = false")
    List<Movie> getAllEnabledMovies();
    Movie searchMovieByMovieName(String movieName);
    Movie searchMovieByMovieId(long movieId);
}
