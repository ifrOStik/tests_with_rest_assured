package io.swagger.petstore.controllers.pet;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.utils.PetStatus;
import io.swagger.petstore.utils.StaticPath;

import static io.restassured.RestAssured.given;

public class PetController {

    private RequestSpecification requestSpecification;

    public PetController() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(StaticPath.BASE_URI)
                .setBasePath(StaticPath.PatPath)
                .setContentType(ContentType.JSON)
                .addHeader(StaticPath.headerName, StaticPath.headerValue)
                .log(LogDetail.ALL).build();
    }

    @Step("Request : Add pet in the shop")
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

    @Step("Request : Delete pet from the shop")
    public void deletePet(String petId) {
        Response response = given(requestSpecification)
                .when()
                .delete(petId);

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

    @Step("Request : Update pet in the shop")
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

    @Step("Request : Bad input body for Update pet")
    public BadResponse updateBadRequest(PetModel pet) {
        return given(requestSpecification)
                .body(pet.getName())
                .put()
                .then()
                .statusCode(400)
                .and()
                .extract().response().as(BadResponse.class);
    }

    @Step("Request : Validation exception request for Update pet")
    public BadResponse updateValidationRequest(PetModel pet) {
        return given(requestSpecification)
                .body(pet)
                .put(pet.getName())
                .then()
                .statusCode(405)
                .and()
                .extract().response().as(BadResponse.class);
    }

    @Step("Request : Update pet with ID")
    public void updatePetById(PetModel pet) {
        given(requestSpecification)
                .body(pet)
                .post()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Step("Request : Bad input body for Update pet by ID")
    public BadResponse updateByIdBadRequest(PetModel pet) {
        return given(requestSpecification)
                .body(pet.getName())
                .post()
                .then()
                .statusCode(400)
                .and()
                .extract().response().as(BadResponse.class);
    }

    @Step("Request : Validation exception request for Update pet")
    public BadResponse updateByIdValidationRequest(PetModel pet) {
        return given(requestSpecification)
                .body(pet)
                .post(pet.getName())
                .then()
                .statusCode(415)
                .and()
                .extract().response().as(BadResponse.class);
    }

    @Step("Request : Get pet from the shop")
    public Object getPetById(String petId) {
        Response response = given(requestSpecification)
                .get(petId);
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

    @Step("Request : Get pet in the status")
    public void getPetByStatus(PetStatus petStatus) {
       given(requestSpecification)
               .get("findByStatus?status=" + petStatus.toString())
               .then()
               .statusCode(200)
               .contentType(ContentType.JSON);
    }

    @Step("Send request without field Status")
    public BadResponse badRequestAddPet(PetModel pet) {
        return given(requestSpecification)
                .body(pet.getName())
                .post()
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .and().extract().response().as(BadResponse.class);
    }

    @Step("Send request with invalid data")
    public BadResponse serverErrorRequestAddPet() {
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







