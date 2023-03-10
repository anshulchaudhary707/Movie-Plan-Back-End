package com.example.movieplan.service;

import com.example.movieplan.payload.AuthenticationRequest;
import com.example.movieplan.payload.AuthenticationResponse;
import org.springframework.security.authentication.BadCredentialsException;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest) throws BadCredentialsException;
}
