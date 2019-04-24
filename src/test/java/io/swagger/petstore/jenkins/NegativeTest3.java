package io.swagger.petstore.jenkins;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.JenkinsCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JenkinsCategory.class)
@Feature("User tests : Negative")
@Story("Jenkins")
@DisplayName("Test for Jenkins")
public class NegativeTest3 {

    @Test
    @DisplayName("Тест : Sending a invalid request, with erroneous parameters")
    @Description("Sending a invalid request, check expected result 500 error")
    public void serverErrorTest() {

        BadResponse actualResponse = new PetController().serverErrorRequestAddPet();
    }
}
