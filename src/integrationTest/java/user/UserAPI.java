package user;

import com.example.demo.model.User;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

/**
 * @author Rakesh Sivanantham
 * Created on 1/13/2018 5:10 PM
 */
public class UserAPI {
    private String hostUrl = "http://localhost:8080";

    @BeforeClass
    public void setUp () {

        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = hostUrl;
        RestAssured.basePath = "/api/v1/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        try {
            System.out.println("Forced wait to let the services start");
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addUser() throws JSONException {

        User user = new User();
        user.setId(System.currentTimeMillis()/1000L);
        user.setName("TestUserName");
        user.setAge(11);

        String json =  new Gson().toJson(user);// obj is your object
        JSONObject jsonObj = new JSONObject(json);

        Response response =
                given()
                        .request()
                        .contentType(ContentType.JSON)
                        .body(jsonObj.toString())
                        .expect()
                        .statusCode(201)
                        .when()
                        .post(String.format("/addUser"));
        System.out.println(response.getBody().asString());

    }
}
