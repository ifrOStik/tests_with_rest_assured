package io.swagger.petstore.controllers.pet;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.models.pet.PetFailResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.utils.StaticData;

import static io.restassured.RestAssured.given;

public class PetController {

    private RequestSpecification requestSpecification;
    private PetModel pet;

    public PetController(PetModel pet) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath(StaticData.PatPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();

        this.pet = pet;
    }

    public PetController() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath(StaticData.PatPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();
    }

    public PetModel addNewPet() {
         return given(requestSpecification)
                 .body(pet)
                 .when()
                 .post()
                 .then()
                 .statusCode(200)
                 .contentType(ContentType.JSON)
                 .and()
                 .extract().response().as(PetModel.class);
    }

    public void deletePet(int statusCode) {
            given(requestSpecification)
                .delete(String.valueOf(pet.getId()))
                    .then()
                    .statusCode(statusCode);
    }

    public PetModel updatePet(int statusCode) {
        return given(requestSpecification)
                .body(pet)
                .put()
                .then()
                .statusCode(statusCode)
                .contentType(ContentType.JSON)
                .and()
                .extract().response().as(PetModel.class);
    }

    public void updatePetById() {
        given(requestSpecification)
                .body(pet)
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public Object getPetById() {
        Response response = given(requestSpecification)
                .get(String.valueOf(pet.getId()));
        if (response.statusCode() == 200) {
            return response.then().contentType(ContentType.JSON)
                    .extract().response().as(PetModel.class);
        } else {
            return response.then().contentType(ContentType.JSON)
                    .extract().response().as(PetFailResponse.class);
        }
    }

    public void getPetByStatus() {
       given(requestSpecification)
               .get("findByStatus?status=" + String.valueOf(pet.getStatus()))
               .then()
               .statusCode(200)
               .contentType(ContentType.JSON);
    }

    public PetFailResponse badRequest() {
        return given(requestSpecification)
                .body("{\n" +
                        " \"id\": " + 1111 + ",\n" +
                        " \"name\": \"testName\",\n" +
                        " \"photoUrls\": [4234234],\n" +
                        " \"tags\": [],\n" +
                        "}")
                .post()
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .and().extract().response().as(PetFailResponse.class);
    }

    public PetFailResponse serverErrorRequest() {
        return given(requestSpecification)
                .body("{\n" +
                        " \"id\": " + 1111 + ",\n" +
                        " \"name\": \"testName\",\n" +
                        " \"photoUrls\": [4234234],\n" +
                        " \"tags\": [234234],\n" +
                        " \"status\": \"pending\"\n" +
                        "}")
                .post()
                .then()
                .statusCode(500)
                .contentType(ContentType.JSON)
                .and().extract().response().as(PetFailResponse.class);
    }
}







