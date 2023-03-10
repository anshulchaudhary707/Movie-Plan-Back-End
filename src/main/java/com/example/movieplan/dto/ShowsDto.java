package com.example.movieplan.dto;

public class ShowsDto {
    private long showId;
    private String date;
    private String time;
    private String movieName;
    private String genreName;
    private Boolean showStatus;

    public ShowsDto() {

    }

    public ShowsDto(String date, String time, String movieName, String genreName, Boolean showStatus) {
        this.date = date;
        this.time = time;
        this.movieName = movieName;
        this.genreName = genreName;
        this.showStatus = showStatus;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
