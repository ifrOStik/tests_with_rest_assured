package io.swagger.petstore.pet.add_pet.positive;

import io.qameta.allure.*;
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
@Story("Добавить питомцев с разными статусами")
@DisplayName("Добавить питомцев с разными статусами")
public class AddPetWithAllStatusTest extends PetDataGenerator {

    @Test
    @DisplayName("Тест : Добавить питомца в статуса AVAILABLE")
    @Description("Добавить питомца в статусе AVAILABLE, с основными параметрами и проверить возвращаемый объект питомца")
    public void addNewPetAvailableStatus() {
        test(PetStatus.available);
    }

    @Test
    @DisplayName("Тест : Добавить питомца в статуса PENDING")
    @Description("Добавить питомца в статусе PENDING, с основными параметрами и проверить возвращаемый объект питомца")
    public void addNewPetPendingStatus() {
        test(PetStatus.pending);
    }

    @Test
    @DisplayName("Тест : Добавить питомца в статуса SOLD")
    @Description("Добавить питомца в статусе SOLD, с основными параметрами и проверить возвращаемый объект питомца")
    public void addNewPetSoldStatus() {
        test(PetStatus.sold);
    }

    private void test(PetStatus petStatus) {

        PetModel pet = petModelRandomGenerator(petStatus);

        PetModel petResponse = new PetController().addNewPet(pet);

        checkResultPetModel(petResponse, pet);
    }
}
