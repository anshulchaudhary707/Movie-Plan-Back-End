package com.example.movieplan.repository;

import com.example.movieplan.model.Shows;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface ShowsRepository extends CrudRepository<Shows,Long> {
    @Query("Select s From Shows s where s.date >=:d AND s.showStatus=true")
    List<Shows> getAllLatestShows(@Param("d")Date date);
    Shows searchShowsByShowId(long showId);
    @Query("Select s From Shows s where s.date >=:d AND s.showStatus=false")
    List<Shows> getAllDisabledShows(@Param("d")Date date);
}