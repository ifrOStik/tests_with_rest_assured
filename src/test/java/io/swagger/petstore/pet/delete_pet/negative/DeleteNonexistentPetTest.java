package io.swagger.petstore.pet.delete_pet.negative;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.NegativeCategory;
import io.swagger.petstore.category.PetTestsCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, PetTestsCategory.class})
@Feature("Pet tests : Negative")
@Story("Delete a non-existent pet")
@DisplayName("Delete a non-existent pet")
public class DeleteNonexistentPetTest extends PetDataGenerator {

    @Test
    @DisplayName("Test : Delete a non-existent pet")
    @Description("Delete a non-existent pet, check that response will be 404 error")
    public void deleteNonexistentPet() {

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.deletePet(pet);
    }
}
