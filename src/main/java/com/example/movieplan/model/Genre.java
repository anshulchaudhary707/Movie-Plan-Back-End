package com.example.movieplan.model;

import javax.persistence.*;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_generator")
    @SequenceGenerator(name = "genre_generator", sequenceName = "genre_seq", allocationSize = 1000)
    private long genreId;
    private String genreName;

    public Genre() { }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public long getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}