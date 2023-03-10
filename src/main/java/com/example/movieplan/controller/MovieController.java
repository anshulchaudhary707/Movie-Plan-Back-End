package com.example.movieplan.controller;

import com.example.movieplan.dto.MovieDto;
import com.example.movieplan.model.Movie;
import com.example.movieplan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MovieController {
    @Autowired private MovieService movieService;
    @PostMapping("/add/movie")
    public ResponseEntity<String> addMovie(@RequestBody MovieDto movieDto){
        Movie movie = this.movieService.addMovie(movieDto);
        if(movie == null){
            return new ResponseEntity<>("Movie Not Added.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Movie Added.", HttpStatus.OK);
    }
    @PostMapping("/edit/movie")
    public ResponseEntity<String> editMovie(@RequestBody MovieDto movieDto){
        Movie movie = this.movieService.editMovie(movieDto);
        if(movie == null){
            return new ResponseEntity<>("Movie Not Edited.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Movie Edited.", HttpStatus.OK);
    }
    @GetMapping("/change/status/{id}") public ResponseEntity<String> changeStatus(@PathVariable("id") int id){
        Movie movie = this.movieService.changeStatus(id);
        if(movie == null){
            return new ResponseEntity<String>("Status Not Changed",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Status Changed",HttpStatus.OK);
    }
    @GetMapping("/all/enabled/movies") public ResponseEntity<List<MovieDto>> getAllEnabledMovies(){
        return new ResponseEntity<List<MovieDto>>(this.movieService.allEnabledMovies(),HttpStatus.OK);
    }
    @GetMapping("/all/disabled/movies") public ResponseEntity<List<MovieDto>> getAllDisabledMovies(){
        return new ResponseEntity<List<MovieDto>>(this.movieService.allDisabledMovies(),HttpStatus.OK);
    }
}
