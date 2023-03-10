package com.example.movieplan.controller;

import com.example.movieplan.dto.ShowsDto;
import com.example.movieplan.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/free")
public class FreeController {
    @Autowired private ShowsService showsService;
    @GetMapping("/all/latest/shows") public ResponseEntity<List<ShowsDto>> getAllLatestShows(){
        return new ResponseEntity<List<ShowsDto>>(this.showsService.getAllLatestShows(), HttpStatus.OK);
    }
}
