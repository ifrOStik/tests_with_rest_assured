package io.swagger.petstore.controllers.user;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.utils.StaticData;


import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class UserController {

    private RequestSpecification requestSpecification;

    public UserController() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath(StaticData.UserPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();
    }

    public void addUsersList(ArrayList<UserModel> userModels) {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath("/v2/user/createWithList")
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();

            given()
                .body(userModels)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void addUsersArray(UserModel[] userModels) {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath("/v2/user/createWithArray")
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();

            given()
                .body(userModels)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void addUser(UserModel user) {
        given(requestSpecification)
                .body(user)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public Object getUser(UserModel user) {
        Response response = given(requestSpecification)
                .when()
                .get(user.getUsername());

        if (response.statusCode() == 200) {
            return response.then()
                    .contentType(ContentType.JSON)
                    .statusCode(200)
                    .and().extract().response().as(UserModel.class);
        } else {
            return response.then()
                    .contentType(ContentType.JSON)
                    .statusCode(404)
                    .and().extract().response().as(BadResponse.class);
        }
    }

    public void loginUser(UserModel user) {
        given(requestSpecification)
                .when()
                .get("login?username=" +  user.getUsername() + "&password=" + user.getPassword())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().extract().response().prettyPrint();
    }

    public void logoutUser() {
        given(requestSpecification)
                .when()
                .get("logout")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().extract().response().prettyPrint();
    }

    public void updateUser(UserModel user) {
        given(requestSpecification)
                .body(user)
                .when()
                .put(user.getUsername())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void deleteUser(UserModel user) {
        Response response = given(requestSpecification)
                .when()
                .delete(user.getUsername());

        if (response.statusCode() == 200) {
            response.then()
                    .statusCode(200)
                    .contentType(ContentType.JSON);
        } else {
            response.then()
                    .statusCode(404)
                    .and().extract().response().body().equals("Not Found");
        }
    }
}
