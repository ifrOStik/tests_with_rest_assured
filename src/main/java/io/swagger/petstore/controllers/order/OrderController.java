package io.swagger.petstore.controllers.order;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.utils.StaticData;


import static io.restassured.RestAssured.given;

public class OrderController {

    private RequestSpecification requestSpecification;
    private OrderModel order;

    public OrderController(OrderModel order) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath(StaticData.OrderPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();

        this.order = order;
    }

    public OrderController() {
    }

    public OrderModel addOrder() {
        return given(requestSpecification)
                .body(order)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().extract().response().as(OrderModel.class);
    }

    public BadResponse addOrderInvalidInput() {

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath(StaticData.OrderPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();

        return given()
                .body("{\n" +
                        " \"id\": " + 111 + ",\n" +
                        " \"petId\": " + 453 + ",\n" +
                        " \"quantity\": " + 3 + ",\n" +
                        " \"shipDate\": \"2018-08-06T15:12:19.468Z\",\n" +
                        " \"status\": \"placed\",\n" +
                        "}")
                .post()
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .and().extract().response().as(BadResponse.class);
    }

    public Object getOrder() {
        Response response = given(requestSpecification)
                .get(String.valueOf(order.getId()));

        if (response.statusCode() == 200) {
            return response.then()
                    .contentType(ContentType.JSON)
                    .and().extract().response().as(OrderModel.class);
        } else {
            return response.then()
                    .contentType(ContentType.JSON)
                    .and().extract().response().as(BadResponse.class);
        }
    }

    public void deleteOrder() {
        Response response = given(requestSpecification)
                .delete(String.valueOf(order.getId()));

        if (response.statusCode() == 200) {
            response.then()
                    .contentType(ContentType.JSON)
                    .and().extract().response().prettyPrint();
        } else {
            response.then()
                    .statusCode(404)
                    .contentType(ContentType.JSON)
                    .and().extract().response().body().equals("Order not found");
        }
    }

    public void getListInventory() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath("/v2/store/inventory")
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();

        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response().prettyPrint();
    }
}
