package com.example.movieplan.controller;

import com.example.movieplan.dto.GenreDto;
import com.example.movieplan.model.Genre;
import com.example.movieplan.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class GenreController {
    @Autowired
    GenreService genreService;
    @PostMapping("/add/genre")
    public ResponseEntity<String> addGenre(@RequestBody GenreDto genreDto){
        Genre genre = this.genreService.addGenre(genreDto);
        if(genre == null){
            return new ResponseEntity<String>("Genre Not Added.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Genre Added.",HttpStatus.OK);
        }
    }
}
