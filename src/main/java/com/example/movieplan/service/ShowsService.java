package com.example.movieplan.service;

import com.example.movieplan.dto.ShowsDto;
import com.example.movieplan.model.Shows;

import java.util.List;

public interface ShowsService {
    List<ShowsDto> getAllLatestShows();
    Shows addShows(ShowsDto showsDto);
    Shows editShow(ShowsDto showsDto);
    Shows changeStatus(long showId);
    List<ShowsDto> getAllDisabledShows();
}
