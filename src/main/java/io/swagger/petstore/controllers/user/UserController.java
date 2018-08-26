package io.swagger.petstore.controllers.user;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.utils.StaticPath;


import javax.xml.soap.SAAJResult;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class UserController {

    private RequestSpecification requestSpecification;

    public UserController() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticPath.BASE_URI)
                .setBasePath(StaticPath.UserPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticPath.headerName, StaticPath.headerValue)
                .log(LogDetail.ALL).build();
    }

    @Step("Request : Create user list")
    public void addUsersList(ArrayList<UserModel> userModels) {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticPath.BASE_URI)
                .setBasePath("/v2/user/createWithList")
                .setContentType(ContentType.JSON)
                .addHeader(StaticPath.headerName, StaticPath.headerValue)
                .log(LogDetail.ALL).build();

            given()
                .body(userModels)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Step("Request : Create user array")
    public void addUsersArray(UserModel[] userModels) {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticPath.BASE_URI)
                .setBasePath("/v2/user/createWithArray")
                .setContentType(ContentType.JSON)
                .addHeader(StaticPath.headerName, StaticPath.headerValue)
                .log(LogDetail.ALL).build();

            given()
                .body(userModels)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Step("Request : Create new user")
    public void addUser(UserModel user) {
        given(requestSpecification)
                .body(user)
                .when()
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Step("Request : Get user")
    public Object getUser(String userName) {
        Response response = given(requestSpecification)
                .when()
                .get(userName);

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

    @Step("Request : Login in the system")
    public String loginUser(String userName, String userPassword) {
       return given(requestSpecification)
                .when()
                .get("login?username=" +  userName + "&password=" + userPassword)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().extract().response().prettyPrint();
    }

    @Step("Request : Logout from the system")
    public void logoutUser() {
        given(requestSpecification)
                .when()
                .get("logout")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().extract().response().prettyPrint();
    }

    @Step("Request : Update user")
    public void updateUser(UserModel user) {
        given(requestSpecification)
                .body(user)
                .when()
                .put(user.getUsername())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Step("Request : Delete user")
    public void deleteUser(String userName) {
        Response response = given(requestSpecification)
                .when()
                .delete(userName);

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
