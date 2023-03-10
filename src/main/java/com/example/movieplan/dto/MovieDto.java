package com.example.movieplan.dto;

public class MovieDto {
    private long movieId;
    private String movieName;
    private String description;
    private String genreName;
    private Double price;
    private Boolean disable;

    public MovieDto() {
    }

    public MovieDto(String movieName, String description, String genreName, Double price, Boolean disable) {
        this.movieName = movieName;
        this.description = description;
        this.genreName = genreName;
        this.price = price;
        this.disable = disable;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
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

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }
}
