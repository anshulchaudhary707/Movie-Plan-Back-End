package com.example.movieplan.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shows_generator")
    @SequenceGenerator(name = "shows_generator", sequenceName = "shows_seq", allocationSize = 1000)
    private long showId;
    private Date date;
    private Time time;
    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @OneToOne
    @JoinColumn(name = "theatre_id")
    private User user;
    private String movieName;
    private String genreName;
    private Boolean showStatus;

    public Shows() {

    }

    public Shows(Date date, Time time, Movie movie, User user, String movieName, String genreName, Boolean showStatus) {
        this.date = date;
        this.time = time;
        this.movie = movie;
        this.user = user;
        this.movieName = movieName;
        this.genreName = genreName;
        this.showStatus = showStatus;
    }

    public long getShowId() {
        return showId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Boolean getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }
}
