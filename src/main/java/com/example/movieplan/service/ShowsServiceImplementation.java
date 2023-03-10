package com.example.movieplan.service;

import com.example.movieplan.dto.ShowsDto;
import com.example.movieplan.model.Movie;
import com.example.movieplan.model.Shows;
import com.example.movieplan.model.User;
import com.example.movieplan.repository.MovieRepository;
import com.example.movieplan.repository.ShowsRepository;
import com.example.movieplan.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ShowsServiceImplementation implements ShowsService {

    @Autowired private ShowsRepository showsRepository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private UserRepository userRepository;
    @Autowired private MovieRepository movieRepository;

    @Override
    public List<ShowsDto> getAllLatestShows() {
        java.util.Date currentDate = Calendar.getInstance().getTime();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        List<Shows> list = this.showsRepository.getAllLatestShows(date);
        List<ShowsDto> list1 = new ArrayList<ShowsDto>();
        for(Shows show : list){
            if(show.getDate().toLocalDate().isEqual(LocalDate.now()) && show.getTime().toLocalTime().isBefore(LocalTime.now().plusMinutes(30))){
                continue;
            }
            else{
                ShowsDto showsDto = this.modelMapper.map(show,ShowsDto.class);
                showsDto.setDate(show.getDate().toString());
                showsDto.setTime(show.getTime().toString());
                list1.add(showsDto);
            }
        }
        return list1;
    }
    @Override
    public Shows addShows(ShowsDto showsDto) {
        Shows shows = this.modelMapper.map(showsDto,Shows.class);
        User user = this.userRepository.searchUserByEmail("theatre@gmail.com");
        Movie movie = this.movieRepository.searchMovieByMovieName(showsDto.getMovieName());
        shows.setUser(user);
        shows.setMovie(movie);
        shows.setDate(Date.valueOf(showsDto.getDate()));
        shows.setTime(Time.valueOf(showsDto.getTime()));
        Shows shows1 = this.showsRepository.save(shows);
        return shows1;
    }
    @Override
    public Shows editShow(ShowsDto showsDto) {
        Shows shows = this.showsRepository.searchShowsByShowId(showsDto.getShowId());
        shows.setShowStatus(showsDto.getShowStatus());
        shows.setMovie(this.movieRepository.searchMovieByMovieName(showsDto.getMovieName()));
        shows.setGenreName(showsDto.getGenreName());
        shows.setMovieName(showsDto.getMovieName());
        shows.setDate(Date.valueOf(showsDto.getDate()));
        shows.setTime(Time.valueOf(showsDto.getTime()));
        Shows shows1 = this.showsRepository.save(shows);
        return shows1;
    }
    @Override
    public Shows changeStatus(long showId) {
        Shows shows = this.showsRepository.searchShowsByShowId(showId);
        shows.setShowStatus(!shows.getShowStatus());
        Shows shows1 = this.showsRepository.save(shows);
        return shows1;
    }
    @Override
    public List<ShowsDto> getAllDisabledShows() {
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        System.out.println("Current Date: "+date);
        List<Shows> list = this.showsRepository.getAllDisabledShows(date);
        List<ShowsDto> list1 = new ArrayList<ShowsDto>();
        for(Shows show : list){
            long now = System.currentTimeMillis()+1000*60*30;
            java.sql.Time time = new Time(now);
            if(show.getDate().toLocalDate().isEqual(LocalDate.now()) && show.getTime().toLocalTime().isBefore(LocalTime.now().plusMinutes(30))){
                continue;
            }
            else{
                ShowsDto showsDto = this.modelMapper.map(show,ShowsDto.class);
                showsDto.setDate(show.getDate().toString());
                showsDto.setTime(show.getTime().toString());
                list1.add(showsDto);
            }
        }
        return list1;
    }
}
