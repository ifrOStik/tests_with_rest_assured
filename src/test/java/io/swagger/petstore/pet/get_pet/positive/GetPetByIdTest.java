package io.swagger.petstore.pet.get_pet.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.category.PetTestsCategory;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, PetTestsCategory.class})
@Feature("Pet tests : Positive")
@Story("Get pet with ID")
@DisplayName("Get pet with ID")
public class GetPetByIdTest extends PetDataGenerator {

    @Test
    @DisplayName("Test : Get pet with ID")
    @Description("Get pet with ID and check that response pet object is equal to the created pet")
    public void getPetById() {

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);

        PetModel petActualResponse = (PetModel) petController.getPetById(String.valueOf(pet.getId()));
        checkResultPetModel(petActualResponse, pet);
    }
}
