import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredApi {

    @Test
    public void getWeatherDetails(){

        //Setting base URI
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET,"/Hyderabad");

        //printing response
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        //Validations checking...

        //Status Code validations...
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println("Status Code:"+statusCode);

        //status Line validations...
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
        System.out.println("Status Line:"+statusLine);
    }

    @Test
    public void postRegisterMethod() throws InterruptedException {
        //Setting base URI
        RestAssured.baseURI="http://restapi.demoqa.com/customer";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request Payload for POST method..

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName","Sharman");
        requestParams.put("LastName","Joshi");
        requestParams.put("UserName","sharman.bat");
        requestParams.put("Password","sharman@234");
        requestParams.put("Email","sharman.joshi@gmail.com");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        Thread.sleep(3000);

        //Respinse object
        Response response = httpRequest.request(Method.POST,"/register");

        //Printing response..
        String resposeBody = response.getBody().asString();
        System.out.println(resposeBody);

        //Validations..

        //Status Code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);

        //Success Code
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode,"OPERATION_SUCCESS");



    }

    @Test
    public void responseBodyTest(){

        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET,"/Delhi");

        //validating response body

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get("City"),"Delhi");
    }
}
