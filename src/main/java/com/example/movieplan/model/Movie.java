package com.example.movieplan.model;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_generator")
    @SequenceGenerator(name = "movie_generator", sequenceName = "movie_seq", allocationSize = 1000)
    private long movieId;
    @Column(unique = true)
    private String movieName;
    private String description;
    private Double price;
    @OneToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    private Boolean disable = false;

    public Movie() { }

    public Movie(String movieName, String description, Double price, Genre genre) {
        this.movieName = movieName;
        this.description = description;
        this.price = price;
        this.genre = genre;
    }

    public long getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }
}
