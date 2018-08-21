package io.swagger.petstore.pet.add_pet.negative;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.category.NegativeCategory;
import io.swagger.petstore.category.PetTestsCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, PetTestsCategory.class})
@Feature("Pet tests : Negative")
@Story("Sending a invalid request, without one parameter")
@DisplayName("Sending a invalid request, without one parameter")
public class BadRequestAddPetTest extends PetDataGenerator{

    @Test
    @DisplayName("Test : Sending a invalid request, without parameter")
    @Description("Sending a invalid request, check expected result the 400 error")
    public void badRequestTest() {

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        BadResponse actualResponse = new  PetController().badRequestAddPet(pet);
        BadResponse expectedResponse = new BadResponse(400, "unknown", "bad input");

        checkErrorResponse(actualResponse, expectedResponse);
    }
}
