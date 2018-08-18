package io.swagger.petstore.pet.get_pet.negative;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
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
@Story("Get a non-existent pet")
@DisplayName("Get a non-existent pet")
public class GetNotExistPetTest extends PetDataGenerator {

    @Test
    @DisplayName("Test : Get a non-existent pet")
    @Description("Get a non-existent pet, check that response will be 404 error")
    public void getNotExistTest() {

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);
        petController.deletePet(pet);

        BadResponse petActualResponse = (BadResponse) petController.getPetById(pet);
        BadResponse expectedResponse = new BadResponse(1, "error", "Pet not found");

        checkErrorResponse(petActualResponse, expectedResponse);
    }
}
