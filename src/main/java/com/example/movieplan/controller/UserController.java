package com.example.movieplan.controller;

import com.example.movieplan.dto.UserDto;
import com.example.movieplan.model.User;
import com.example.movieplan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/free")
public class UserController {
    @Autowired private UserService userService;
    @PostMapping("/add/admin")
    public ResponseEntity<String> addAdmin(@RequestBody UserDto userDto){
        User user = this.userService.addAdmin(userDto);
        if(user == null){
            return new ResponseEntity<String>("User not Added.", HttpStatus.OK);
        }
        return new ResponseEntity<String>("User Added Successfully.", HttpStatus.OK);
    }
    @PostMapping("/add/normal")
    public ResponseEntity<String> addNormal(@RequestBody UserDto userDto){
        User user = this.userService.addNormal(userDto);
        if(user == null){
            return new ResponseEntity<String>("User not Added.", HttpStatus.OK);
        }
        return new ResponseEntity<String>("User Added Successfully.", HttpStatus.OK);
    }
    @PostMapping("/add/theatre")
    public ResponseEntity<String> addTheatre(@RequestBody UserDto userDto){
        User user = this.userService.addTheatre(userDto);
        if(user == null){
            return new ResponseEntity<String>("User not Added.", HttpStatus.OK);
        }
        return new ResponseEntity<String>("User Added Successfully.", HttpStatus.OK);
    }
}
