package com.example.movieplan.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_generator")
    @SequenceGenerator(name = "cart_generator", sequenceName = "cart_seq", allocationSize = 1000)
    private long cartId;
    @OneToOne
    @JoinColumn(name = "show_id")
    private Shows show;
    private Date date;
    private Time time;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int quantity = 0;
    private String theatreId;
    private String theatreName;
    private String theatreAddress;

    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Cart(Shows show, Date date, Time time, User user, int quantity, String theatreId, String theatreName, String theatreAddress) {
        this.show = show;
        this.date = date;
        this.time = time;
        this.user = user;
        this.quantity = quantity;
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.theatreAddress = theatreAddress;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public Shows getShow() {
        return show;
    }

    public void setShow(Shows show) {
        this.show = show;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}