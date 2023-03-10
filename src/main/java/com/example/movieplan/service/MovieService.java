package com.example.movieplan.service;

import com.example.movieplan.dto.MovieDto;
import com.example.movieplan.model.Movie;

import java.util.List;

public interface MovieService {
    Movie addMovie(MovieDto movieDto);
    Movie editMovie(MovieDto movieDto);
    Movie changeStatus(long movieId);
    List<MovieDto> allEnabledMovies();
    List<MovieDto> allDisabledMovies();
}
