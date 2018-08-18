package io.swagger.petstore.pet.update_pet.positive;

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
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, PetTestsCategory.class})
@Feature("Pet tests : Positive")
@Story("Update pet in the shop")
@DisplayName("Update pet in the shop")
public class UpdatePetTest extends PetDataGenerator {

    @Test
    @DisplayName("Test : Update pet")
    @Description("Update pet in the shop and check that response pet is equals created pet")
    public void updatePetTest() {

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);

        pet.setStatus(PetStatus.sold.name());
        pet.setName(RandomStringUtils.randomAlphanumeric(6));
        pet.setPhotoUrls(petPhotoUrlGenerator());

        PetModel petActualResponse = petController.updatePet(pet);

        checkResultPetModel(petActualResponse, pet);
    }
}
