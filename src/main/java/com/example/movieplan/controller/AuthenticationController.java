package com.example.movieplan.controller;

import com.example.movieplan.payload.AuthenticationRequest;
import com.example.movieplan.payload.AuthenticationResponse;
import com.example.movieplan.exception.ApiException;
import com.example.movieplan.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/free")
public class AuthenticationController {
    @Autowired private AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialsException {
        AuthenticationResponse authenticationResponse;
        try{
            authenticationResponse = this.authenticationService.login(authenticationRequest);
        }catch (BadCredentialsException badCredentialsException){
            throw new ApiException("Invalid Email Or Password");
        }
        return new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
    }
}
