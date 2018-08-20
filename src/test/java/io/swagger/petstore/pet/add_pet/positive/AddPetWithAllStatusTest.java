package io.swagger.petstore.pet.add_pet.positive;

import io.qameta.allure.*;
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
@Story("Create pets with all status")
@DisplayName("Create pets with all status")
public class AddPetWithAllStatusTest extends PetDataGenerator {

    @Test
    @DisplayName("Test : Create pet in the AVAILABLE status")
    @Description("Create pet in the AVAILABLE status, with primary parameters and check the returned pet object")
    public void addNewPetAvailableStatus() {
        test(PetStatus.available);
    }

    @Test
    @DisplayName("Test : Create pet in the PENDING status")
    @Description("Create pet in the PENDING status, with primary parameters and check the returned pet object")
    public void addNewPetPendingStatus() {
        test(PetStatus.pending);
    }

    @Test
    @DisplayName("Test : Create pet in the SOLD status")
    @Description("Create pet in the SOLD status, with primary parameters and check the returned pet object")
    public void addNewPetSoldStatus() {
        test(PetStatus.sold);
    }

    private void test(PetStatus petStatus) {

        PetModel pet = petModelRandomGenerator(petStatus);

        PetModel petResponse = new PetController().addNewPet(pet);

        checkResultPetModel(petResponse, pet);
    }
}
