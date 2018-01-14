package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@Api(tags="Sample API", description="My sample API")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Add a new user")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody User user, HttpServletResponse httpServletResponse) throws IOException, ParseException {
        return userService.addUser(user, httpServletResponse);
    }


    @ApiOperation(value = "Get added user")
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public Object getUser(@PathVariable("id") long id, HttpServletResponse httpServletResponse) throws IOException, ParseException {
        return userService.getUser(id, httpServletResponse);
    }
}
