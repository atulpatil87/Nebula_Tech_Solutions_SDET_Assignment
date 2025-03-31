package test.java.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class APITest {
    @Test
    public void testGetPost() {
        // Send GET request and validate status code
        Response response = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .extract().response();

        // Extract title and body from response
        String title = response.path("title");
        String body = response.path("body");

        // Print results
        System.out.println("Title: " + title);
        System.out.println("Body: " + body);

        // Validate fields are not empty (optional)
        assertEquals(title.isEmpty(), false, "Title is empty");
        assertEquals(body.isEmpty(), false, "Body is empty");
    }
}