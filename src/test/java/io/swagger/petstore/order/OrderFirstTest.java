package io.swagger.petstore.order;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.petstore.utils.StaticData;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class OrderFirstTest {

    @Test
    public void test() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath("/store/inventory")
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();

        Response response = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON).and().extract().response().andReturn();

        response.getBody();
    }
}
