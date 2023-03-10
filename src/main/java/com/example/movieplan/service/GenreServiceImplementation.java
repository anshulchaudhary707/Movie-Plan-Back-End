package com.example.movieplan.service;

import com.example.movieplan.dto.GenreDto;
import com.example.movieplan.model.Genre;
import com.example.movieplan.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImplementation implements GenreService {
    @Autowired private GenreRepository genreRepository;
    @Autowired private ModelMapper modelMapper;

    @Override
    public Genre addGenre(GenreDto genreDto) {
        Genre genre = this.modelMapper.map(genreDto,Genre.class);
        return this.genreRepository.save(genre);
    }
}
