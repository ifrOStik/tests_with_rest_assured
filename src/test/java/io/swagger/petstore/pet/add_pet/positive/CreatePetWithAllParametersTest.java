package io.swagger.petstore.pet.add_pet.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
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
@Story("Create pets with all parameters")
@DisplayName("Create pets with all parameters")
public class CreatePetWithAllParametersTest extends PetDataGenerator{

    @Test
    @DisplayName("Test : Create pet with all parameters")
    @Description("Create pet with all parameters and check the returned valid pet object")
    public void test() {
        PetModel pet = petModelGeneratorWithAllParameters(PetStatus.available);

        PetController petController = new PetController();
        PetModel actualPetResponse = petController.addNewPet(pet);

        checkResultPetModelRecursively(actualPetResponse, pet);
    }
}
