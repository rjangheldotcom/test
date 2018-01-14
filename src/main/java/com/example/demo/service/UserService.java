package com.example.demo.service;

import com.example.demo.model.User;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Rakesh Sivanantham
 * Created on 1/13/2018 4:49 PM
 */
public interface UserService {
    String addUser(User user, HttpServletResponse httpServletResponse) throws IOException, ParseException;

    Object getUser(long id, HttpServletResponse httpServletResponse) throws IOException, ParseException;
}
