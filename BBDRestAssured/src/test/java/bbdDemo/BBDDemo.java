package bbdDemo;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BBDDemo {

    public static HashMap map=new HashMap();
    @Test
    public void getWeather(){
        given()
                .when()
                .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("City",equalTo("Hyderabad"))
                .header("Content-Type","application/json");
    }

    @BeforeClass
    public void postData(){
        map.put("FirstName",ResultUtils.getFirstName());
        map.put("LastName",ResultUtils.getLastName());
        map.put("UserName",ResultUtils.getUserName());
        map.put("Password",ResultUtils.getPassword());
        map.put("Email",ResultUtils.getEmail());

        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RestAssured.basePath = "/register";

    }

    @Test
    public void testPost(){
        given()
                .contentType("application/json")
                .body(map)
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("Message",equalTo("Operation completed successfully"))
                .body("SuccessCode",equalTo("OPERATION_SUCCESS"));
    }
}
