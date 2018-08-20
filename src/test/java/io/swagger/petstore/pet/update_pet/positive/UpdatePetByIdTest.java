package io.swagger.petstore.pet.update_pet.positive;

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
@Story("Update pet in the shop by ID")
@DisplayName("Update pet in the shop by ID")
public class UpdatePetByIdTest extends PetDataGenerator {

    @Test
    @DisplayName("Test : Update pet by ID")
    @Description("Update pet in the shop by ID and check that response pet is equals updated pet")
    public void updatePetTest() {

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);

        pet.setStatus(PetStatus.sold.name());
        pet.setName(petNameGenerator());
        pet.setId(petIdGenerator());

        petController.updatePetById(pet);

        PetModel petActualResponse = (PetModel) petController.getPetById(pet);
        checkResultPetModel(petActualResponse, pet);
    }
}
