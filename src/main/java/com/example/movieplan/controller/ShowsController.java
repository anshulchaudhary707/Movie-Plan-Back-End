package com.example.movieplan.controller;

import com.example.movieplan.dto.MovieDto;
import com.example.movieplan.dto.ShowsDto;
import com.example.movieplan.model.Shows;
import com.example.movieplan.service.MovieService;
import com.example.movieplan.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class ShowsController {
    @Autowired private ShowsService showsService;
    @Autowired private MovieService movieService;
    @GetMapping("/all/latest/shows") public ResponseEntity<List<ShowsDto>> getAllLatestShows(){
        return new ResponseEntity<List<ShowsDto>>(this.showsService.getAllLatestShows(), HttpStatus.OK);
    }
    @GetMapping("/all/disabled/shows") public ResponseEntity<List<ShowsDto>> getAllDisabledShows(){
        return new ResponseEntity<List<ShowsDto>>(this.showsService.getAllDisabledShows(), HttpStatus.OK);
    }
    @PostMapping("/add/show") public ResponseEntity<String> addShow(@RequestBody ShowsDto showsDto){
        Shows shows = this.showsService.addShows(showsDto);
        if(shows == null){
            return new ResponseEntity<String>("Show Not Added",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Show Added",HttpStatus.OK);
    }
    @PostMapping("/edit/show") public ResponseEntity<String> editShow(@RequestBody ShowsDto showsDto){
        Shows shows = this.showsService.editShow(showsDto);
        if(shows == null){
            return new ResponseEntity<String>("Show Not Edited",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Show Edited",HttpStatus.OK);
    }
    @GetMapping("/change/status/{id}") public ResponseEntity<String> changeStatus(@PathVariable("id") long id){
        Shows shows = this.showsService.changeStatus(id);
        if(shows == null){
            return new ResponseEntity<String>("Status Not Changed",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Status Changed",HttpStatus.OK);
    }
    @GetMapping("/all/movies") public ResponseEntity<List<MovieDto>> getAllMovies(){
        return new ResponseEntity<List<MovieDto>>(this.movieService.allEnabledMovies(),HttpStatus.OK);
    }
}
