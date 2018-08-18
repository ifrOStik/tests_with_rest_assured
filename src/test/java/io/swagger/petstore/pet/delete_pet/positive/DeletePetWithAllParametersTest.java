package io.swagger.petstore.pet.delete_pet.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.PetTestsCategory;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, PetTestsCategory.class})
@Feature("Pet tests : Positive")
@Story("Delete pet with all parameters")
@DisplayName("Delete pet with all parameters")
public class DeletePetWithAllParametersTest extends PetDataGenerator {

    @Test
    @DisplayName("Test : Delete pet with all parameters")
    @Description("Delete pet, check that response will be null")
    public void deletePetWithAllParameters() {

        PetModel pet = petModelGeneratorWithAllParameters(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);
        petController.deletePet(pet);

        BadResponse petActualResponse = (BadResponse) petController.getPetById(pet);

        BadResponse expectedResponse = new BadResponse(1, "error", "Pet not found");

        checkErrorResponse(petActualResponse, expectedResponse);
    }
}
