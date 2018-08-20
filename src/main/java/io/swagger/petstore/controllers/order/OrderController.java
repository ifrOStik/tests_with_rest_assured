package io.swagger.petstore.controllers.order;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.utils.StaticPath;


import static io.restassured.RestAssured.given;

public class OrderController {

    private RequestSpecification requestSpecification;

    public OrderController() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticPath.BASE_URI)
                .setBasePath(StaticPath.OrderPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticPath.headerName, StaticPath.headerValue)
                .log(LogDetail.ALL).build();
    }

    @Step("Request : Add order in the shop")
    public OrderModel addOrder(OrderModel order) {
        return given(requestSpecification)
                .body(order)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().extract().response().as(OrderModel.class);
    }

    @Step("Request : Send request with invalid data")
    public BadResponse addOrderInvalidInput() {

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticPath.BASE_URI)
                .setBasePath(StaticPath.OrderPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticPath.headerName, StaticPath.headerValue)
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

    @Step("Request : Get order from the shop")
    public Object getOrder(OrderModel order) {
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

    @Step("Request : Delete order from the shop")
    public void deleteOrder(OrderModel order) {
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

    @Step("Request : Get inventory list from the shop")
    public void getListInventory() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticPath.BASE_URI)
                .setBasePath("/v2/store/inventory")
                .setContentType(ContentType.JSON)
                .addHeader(StaticPath.headerName, StaticPath.headerValue)
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
