package com.example.demo.controllers;

import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public User getUserByName(String name) {
        return userService.getUserByName(name);
    }

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByNameInPath(@PathVariable  String name) {
        return userService.getUserByName(name);
    }
}
