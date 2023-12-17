package com.salahin.rocky.controller;


import com.salahin.rocky.dto.UserDto;
import com.salahin.rocky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @GetMapping
    public List<UserDto> getProducts() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUsersById(@PathVariable int id) {
        return userService.getUsersById(id);
    }


    @PutMapping()
    public UserDto updateUsersById(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/{id}")
    public long deleteUsersById(@PathVariable int id){
        return userService.deleteUsersById(id);
    }


}
