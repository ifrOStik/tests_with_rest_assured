package io.swagger.petstore.controllers.pet;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.utils.PetStatus;
import io.swagger.petstore.utils.StaticData;

import static io.restassured.RestAssured.given;

public class PetController {

    private RequestSpecification requestSpecification;

    public PetController() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticData.BASE_URI)
                .setBasePath(StaticData.PatPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticData.headerName, StaticData.headerValue)
                .log(LogDetail.ALL).build();
    }

    public PetModel addNewPet(PetModel pet) {
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

    public void deletePet(PetModel pet) {
        Response response = given(requestSpecification)
                .when()
                .delete(String.valueOf(pet.getId()));

        if (response.statusCode() == 200) {
            response.then()
                    .statusCode(200)
                    .contentType(ContentType.JSON);
        } else {
            response.then()
                    .statusCode(404)
                    .and().extract().response().body().equals("Pet not found");
        }
    }

    public PetModel updatePet(PetModel pet) {
        return given(requestSpecification)
                .body(pet)
                .put()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and()
                .extract().response().as(PetModel.class);
    }

    public void updatePetById(PetModel pet) {
        given(requestSpecification)
                .body(pet)
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public Object getPetById(PetModel pet) {
        Response response = given(requestSpecification)
                .get(String.valueOf(pet.getId()));
        if (response.statusCode() == 200) {
            return response.then()
                    .contentType(ContentType.JSON)
                    .extract().response().as(PetModel.class);
        } else {
            return response.then()
                    .contentType(ContentType.JSON)
                    .extract().response().as(BadResponse.class);
        }
    }

    public void getPetByStatus(PetStatus petStatus) {
       given(requestSpecification)
               .get("findByStatus?status=" + petStatus.toString())
               .then()
               .statusCode(200)
               .contentType(ContentType.JSON);
    }

    public BadResponse badRequest() {
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
                .and().extract().response().as(BadResponse.class);
    }

    public BadResponse serverErrorRequest() {
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
                .and().extract().response().as(BadResponse.class);
    }
}







