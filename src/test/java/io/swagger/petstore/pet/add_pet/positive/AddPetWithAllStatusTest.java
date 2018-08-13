package io.swagger.petstore.pet.add_pet.positive;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;

@Feature("Pet tests")
@DisplayName("Добавить питомцев с разными статусами")
public class AddPetWithAllStatusTest extends PetDataGenerator {

    @Test
    @DisplayName("Тест : Добавить питомца в статуса AVAILABLE")
    @Description("Данный тест добавляет питомца в статусе AVAILABLE, " +
            "с основными параметрами и проверяет" +
            "возвращаемый объект питомца с тем что был сгенерирован")
    public void addNewPetAvailableStatus() {
        test(PetStatus.available);
    }

    @Test
    @DisplayName("Тест : Добавить питомца в статуса PENDING")
    @Description("Добавить питомца в статусе PENDING")
    public void addNewPetPendingStatus() {
        test(PetStatus.pending);
    }

    @Test
    @DisplayName("Тест : Добавить питомца в статуса SOLD")
    @Description("Добавить питомца в статусе SOLD")
    public void addNewPetSoldStatus() {
        test(PetStatus.sold);
    }

    @Step("Добавить питомца в магазин")
    private void test(PetStatus petStatus) {

        PetModel pet = petModelRandomGenerator(petStatus);

        PetModel petResponse = new PetController().addNewPet(pet);

        PetModelAssert.assertThat(petResponse).isEqualTo(pet);
    }
}
