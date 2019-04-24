package io.swagger.petstore.jenkins;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.category.JenkinsCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JenkinsCategory.class)
@Feature("User tests : Negative")
@Story("Jenkins")
@DisplayName("Test for Jenkins")
public class NegativeTest2 {

    @Test
    @DisplayName("Test : Get pet with ID")
    @Description("Get pet with ID and check that response pet object is equal to the created pet")
    public void getPetById() {

        PetController petController = new PetController();
        String petId = "asdasd9340439poiyporti";

        PetModel petActualResponse = (PetModel) petController.getPetById(petId);

        PetModelAssert.assertThat(petActualResponse).hasId(Integer.valueOf(petId));
    }
}
