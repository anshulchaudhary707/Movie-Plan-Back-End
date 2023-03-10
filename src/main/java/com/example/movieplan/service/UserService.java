package com.example.movieplan.service;

import com.example.movieplan.dto.UserDto;
import com.example.movieplan.model.User;

public interface UserService {
    User addAdmin(UserDto userDto);
    User addNormal(UserDto userDto);
    User addTheatre(UserDto userDto);
}
