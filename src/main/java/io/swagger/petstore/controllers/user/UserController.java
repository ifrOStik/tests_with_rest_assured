package io.swagger.petstore.controllers.user;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.utils.StaticData;


import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class UserController {

    private RequestSpecification requestSpecification;
    private UserModel user;

    public UserController(UserModel user) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath(StaticData.UserPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();

        this.user = user;
    }

    public UserController() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath(StaticData.UserPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();
    }

    public void addUsersList(ArrayList<UserModel> userModels) {
        given(requestSpecification)
                .body(userModels)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void addUsersArray(UserModel[] userModels) {
        given(requestSpecification)
                .body(userModels)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void addUser() {
        given(requestSpecification)
                .body(user)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public UserModel getUser() {
        return given(requestSpecification)
                .when()
                .get(user.getUsername())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().extract().response().as(UserModel.class);
    }

    public void loginUser(String username, String password) {
        given(requestSpecification)
                .when()
                .get("login?username=" + username + "&password=" + password)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().extract().response().prettyPrint();
    }

    public void updateUser() {
        given(requestSpecification)
                .body(user)
                .when()
                .put(user.getUsername())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void deleteUser() {
        given(requestSpecification)
                .when()
                .delete(user.getUsername())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
