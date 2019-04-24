package io.swagger.petstore.jenkins;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.JenkinsCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JenkinsCategory.class)
@Feature("User tests : Positive")
@Story("Jenkins")
@DisplayName("Test for Jenkins")
public class PositiveTest {

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
