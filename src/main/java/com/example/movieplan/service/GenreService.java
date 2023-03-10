package com.example.movieplan.service;

import com.example.movieplan.dto.GenreDto;
import com.example.movieplan.model.Genre;

public interface GenreService {
    Genre addGenre(GenreDto genreDto);
}
