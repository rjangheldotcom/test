package com.example.demo;

import com.example.demo.controllers.UserController;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@WebAppConfiguration
public class ControllerTest {
    @InjectMocks
    public UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;


    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void addUserTest() throws Exception{
        when(userService.addUser(any(User.class),any(HttpServletResponse.class))).thenReturn(anyString());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addUser"))
                .andReturn();
        Assert.assertNotNull(mvcResult.getResponse());
    }

}
