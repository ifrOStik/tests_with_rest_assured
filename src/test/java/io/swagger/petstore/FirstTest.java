package io.swagger.petstore;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by temaustimcik on 2018-07-06.
 */
public class FirstTest {

    @Test
    public void fTest() {
        
        int id = 1234566657;

            given()
                .baseUri("http://petstore.swagger.io")
                .basePath("/v2/pet")
                .header("api_key", "qwerty123")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        " \"id\": " + 1111 + ",\n" +
                        " \"name\": \"testName\",\n" +
                        " \"photoUrls\": [4234234],\n" +
                        " \"tags\": [],\n" +
                        " \"status\": \"pending\"\n" +
                        "}")
                .when().post()
                .then()
                .statusCode(200)
                .extract().response().prettyPrint();
    }
}
