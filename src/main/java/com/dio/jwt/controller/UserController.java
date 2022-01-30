package com.dio.jwt.controller;

import com.dio.jwt.data.UserData;
import com.dio.jwt.service.UserDetailServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserDetailServiceImpl userDetailService;

    public UserController(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/users")
    public List<UserData> listAllUsers(){
        return userDetailService.listUser();
    }
}
