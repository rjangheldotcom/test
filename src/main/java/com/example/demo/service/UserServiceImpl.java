package com.example.demo.service;

import com.example.demo.model.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Rakesh Sivanantham
 * Created on 1/13/2018 4:49 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String addUser(User user, HttpServletResponse httpServletResponse) throws IOException, ParseException {
        if(user==null || user.getName()==null || user.getAge()==0 || user.getId()==0){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Not accepted";
        }
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("data.json"));
        JSONObject jsonObject = (JSONObject) object;
        if(jsonObject.containsKey("USER"+user.getId())){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Not accepted";
        }
        JSONObject obj = new JSONObject();
        obj.put("name", user.getName());
        obj.put("age", user.getAge());
        jsonObject.put("USER"+user.getId(), obj);
        try (FileWriter file = new FileWriter("data.json")) {
            file.write(jsonObject.toJSONString());
            httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);
        }
        return "User Created";
    }

    @Override
    public Object getUser(long id, HttpServletResponse httpServletResponse) throws IOException, ParseException {
        if(id==0){
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "No user found";
        }
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("data.json"));
        JSONObject jsonObject = (JSONObject) object;
        if(!jsonObject.containsKey("USER"+id)){
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "No user found";
        }
        Object obj = jsonObject.get("USER"+id);
        return obj;
    }


}
