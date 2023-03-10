package com.example.movieplan.repository;

import com.example.movieplan.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre,Long> {
    Genre searchGenreByGenreName(String genreName);
}
