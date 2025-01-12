package code;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETStatus {

    String url = "https://simple-books-api.glitch.me";

    @Test
    void happyPathTest() {

        Response response = RestAssured.get("https://simple-books-api.glitch.me/status");

        System.out.println("Response: " + response.asString());

        System.out.println("Status Code: " +response.getStatusCode());

        System.out.println("Time taken: " +response.getTime());

        System.out.println("Response: " + response.getBody().asString());

        System.out.println("Content Type: " + response.getHeader("Content-Type"));

        System.out.println("Content Length: "+response.getHeader("Content-Length"));

        System.out.println("Date: " + response.getHeader("Date"));

        System.out.println("All Headers: "+ response.getHeaders());
    }

    @Test
    (description = "Given baseurl When make GET call to /status Then Verify status code equal to 200")
    void ValidateStatusCode(){

        // Given
        String url = "https://simple-books-api.glitch.me";

        //When
        Response response = RestAssured.get(url+ "/status");
        int actualStatusCode= response.getStatusCode();
        int expectedStatusCode = 200;

        //Then
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code should be 200 but it is "+ actualStatusCode);
    }

    @Test
    (description = "Given baseUrl When make GET call to /status Then time taken must be under 2000")
    void ValidateTimeTaken(){

        // Given
        String url = "https://simple-books-api.glitch.me";

        //When
        Response response = RestAssured.get(url+ "/status");
        long actualTimeTaken= response.getTime();
        int expectedStatusCode = 2000;

    }
}