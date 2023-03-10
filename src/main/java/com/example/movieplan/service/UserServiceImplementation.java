package com.example.movieplan.service;

import com.example.movieplan.dto.UserDto;
import com.example.movieplan.exception.IntegrityConstraintViolation;
import com.example.movieplan.model.Role;
import com.example.movieplan.model.User;
import com.example.movieplan.repository.RoleRepository;
import com.example.movieplan.repository.UserRepository;
import com.example.movieplan.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service public class UserServiceImplementation implements UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private RoleRepository roleRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Override
    public User addAdmin(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = this.roleRepository.searchRoleById(501);
        user.getRoles().add(role);
        User user1 = null;
        try{
            user1 = this.userRepository.save(user);
        }
        catch (DataIntegrityViolationException exception){
            throw new IntegrityConstraintViolation(user.getEmail(),"user");
        }
        return user1;
    }

    @Override
    public User addNormal(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = this.roleRepository.searchRoleById(502);
        user.getRoles().add(role);
        User user1 = null;
        try{
            user1 = this.userRepository.save(user);
        }
        catch (DataIntegrityViolationException exception){
            throw new IntegrityConstraintViolation(user.getEmail(),"user");
        }
        return user1;
    }

    @Override
    public User addTheatre(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = this.roleRepository.searchRoleById(503);
        user.getRoles().add(role);
        User user1 = null;
        try{
            user1 = this.userRepository.save(user);
        }
        catch (DataIntegrityViolationException exception){
            throw new IntegrityConstraintViolation(user.getEmail(),"user");
        }
        return user1;
    }
}
