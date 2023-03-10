package com.example.movieplan.dto;

public class CartDto {
    private long cartId;
    private int quantity = 0;
    private String theatreId;
    private String theatreName;
    private String theatreAddress;
    private String movieName;
    private String date;
    private String time;
    private String nameOfCustomer;

    public CartDto() {

    }

    public CartDto(long cartId, int quantity, String theatreId, String theatreName, String theatreAddress, String movieName, String date, String time, String nameOfCustomer) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.theatreAddress = theatreAddress;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.nameOfCustomer = nameOfCustomer;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreAddress() {
        return theatreAddress;
    }

    public void setTheatreAddress(String theatreAddress) {
        this.theatreAddress = theatreAddress;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }
}
