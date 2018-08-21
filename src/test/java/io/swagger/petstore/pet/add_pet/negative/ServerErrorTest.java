package io.swagger.petstore.pet.add_pet.negative;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.NegativeCategory;
import io.swagger.petstore.category.PetTestsCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.pet.PetDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, PetTestsCategory.class})
@Feature("Pet tests : Negative")
@Story("Sending a invalid request, with erroneous parameters")
@DisplayName("Sending a invalid request, with erroneous parameters")
public class ServerErrorTest extends PetDataGenerator {

    @Test
    @DisplayName("Тест : Sending a invalid request, with erroneous parameters")
    @Description("Sending a invalid request, check expected result 500 error")
    public void serverErrorTest() {

        BadResponse actualResponse = new PetController().serverErrorRequestAddPet();
        BadResponse expectedResponse = new BadResponse(500, "unknown", "something bad happened");

        checkErrorResponse(actualResponse, expectedResponse);
    }
}
