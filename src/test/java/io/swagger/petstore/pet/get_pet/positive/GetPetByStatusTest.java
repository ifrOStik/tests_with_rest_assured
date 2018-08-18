package io.swagger.petstore.pet.get_pet.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.PetTestsCategory;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, PetTestsCategory.class})
@Feature("Pet tests : Positive")
@Story("Get pet with all status")
@DisplayName("Get pet with all status")
public class GetPetByStatusTest extends PetDataGenerator {

    @Test
    @DisplayName("Test : Get pets in the AVAILABLE status")
    @Description("Get pets in the AVAILABLE status")
    public void getPetsWithAvailableStatus(){
        test(PetStatus.available);
    }

    @Test
    @DisplayName("Test : Get pets in the PENDING status")
    @Description("Create pets in the AVAILABLE status")
    public void getPetsWithPendingStatus(){
        test(PetStatus.pending);
    }

    @Test
    @DisplayName("Test : Get pets in the SOLD status")
    @Description("Create pets in the AVAILABLE status")
    public void getPetsWithSoldStatus(){
        test(PetStatus.sold);
    }


    private void test(PetStatus petStatus) {

        new PetController().getPetByStatus(petStatus);
    }
}
