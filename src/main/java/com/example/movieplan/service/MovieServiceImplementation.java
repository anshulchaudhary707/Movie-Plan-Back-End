package com.example.movieplan.service;

import com.example.movieplan.dto.MovieDto;
import com.example.movieplan.model.Genre;
import com.example.movieplan.model.Movie;
import com.example.movieplan.repository.GenreRepository;
import com.example.movieplan.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {
    @Autowired private ModelMapper modelMapper;
    @Autowired private GenreRepository genreRepository;
    @Autowired private MovieRepository movieRepository;
    @Override
    public Movie addMovie(MovieDto movieDto) {
        Movie movie  =this.modelMapper.map(movieDto, Movie.class);
        Genre genre = this.genreRepository.searchGenreByGenreName(movieDto.getGenreName());
        movie.setGenre(genre);
        Movie movie1 = this.movieRepository.save(movie);
        return movie1;
    }

    @Override
    public Movie editMovie(MovieDto movieDto) {
        Movie movie  =this.movieRepository.searchMovieByMovieId(movieDto.getMovieId());
        Genre genre = this.genreRepository.searchGenreByGenreName(movieDto.getGenreName());
        movie.setGenre(genre);
        movie.setMovieName(movieDto.getMovieName());
        movie.setPrice(movieDto.getPrice());
        movie.setDisable(movieDto.getDisable());
        movie.setDescription(movieDto.getDescription());
        Movie movie1 = this.movieRepository.save(movie);
        return movie1;
    }

    @Override
    public Movie changeStatus(long movieId) {
        Movie movie = this.movieRepository.searchMovieByMovieId(movieId);
        movie.setDisable(!movie.getDisable());
        Movie movie1 = this.movieRepository.save(movie);
        return movie1;
    }

    @Override
    public List<MovieDto> allEnabledMovies() {
        List<Movie> list = this.movieRepository.getAllEnabledMovies();
        List<MovieDto> list1 = new ArrayList<>();
        for(Movie movie : list){
            MovieDto movieDto = this.modelMapper.map(movie,MovieDto.class);

            list1.add(movieDto);
        }
        return list1;
    }

    @Override
    public List<MovieDto> allDisabledMovies() {
        List<Movie> list = this.movieRepository.getAllDisabledMovies();
        List<MovieDto> list1 = new ArrayList<>();
        for(Movie movie : list){
            MovieDto movieDto = this.modelMapper.map(movie,MovieDto.class);
            list1.add(movieDto);
        }
        return list1;
    }
}
