package io.swagger.petstore.pet.update_pet.negative;

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
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, PetTestsCategory.class})
@Feature("Pet tests : Negative")
@Story("Validation exception fot update pet by ID")
@DisplayName("Validation exception fot update pet by ID")
public class UpdateByIDValidationExceptionTest extends PetDataGenerator{

    @Test
    @DisplayName("Test : Validation exception for update pet by ID")
    @Description("Validation exception fot update pet by ID and check that response will be 415 error")
    public void test() {

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);

        pet.setStatus(PetStatus.sold.name());
        pet.setName(RandomStringUtils.randomAlphanumeric(6));
        pet.setPhotoUrls(petPhotoUrlGenerator());

        BadResponse actualPetResponse = petController.updateByIdValidationRequest(pet);
        BadResponse expectedResponse = new BadResponse(0, "unknown", null);

        checkErrorResponse(actualPetResponse, expectedResponse);
    }
}
