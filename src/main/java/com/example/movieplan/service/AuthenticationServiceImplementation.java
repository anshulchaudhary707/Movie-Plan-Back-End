package com.example.movieplan.service;

import com.example.movieplan.payload.AuthenticationRequest;
import com.example.movieplan.payload.AuthenticationResponse;
import com.example.movieplan.model.User;
import com.example.movieplan.repository.UserRepository;
import com.example.movieplan.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService {
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private UserRepository userRepository;
    @Autowired private JwtService jwtService;
    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) throws BadCredentialsException {
        try{
            this.authenticate(authenticationRequest.getEmail(),authenticationRequest.getPassword());
        }catch (Exception bce){
            throw bce;
        }
        User user = this.userRepository.searchUserByEmail(authenticationRequest.getEmail());
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken,user);
    }
    private void authenticate(String email, String password) throws BadCredentialsException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,
                password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException exception) {
            throw exception;
        }
    }
}