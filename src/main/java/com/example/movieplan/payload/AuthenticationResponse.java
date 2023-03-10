package com.example.movieplan.payload;

import com.example.movieplan.model.User;

public class AuthenticationResponse {

    private String token;
    private User user;

    public AuthenticationResponse() {
        super();
    }

    public AuthenticationResponse(String token, User user) {
        super();
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}