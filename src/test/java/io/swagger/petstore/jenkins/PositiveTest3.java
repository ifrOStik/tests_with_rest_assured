package io.swagger.petstore.jenkins;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.category.JenkinsCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.utils.PetStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;

@Category(JenkinsCategory.class)
@Feature("User tests : Positive")
@Story("Jenkins")
@DisplayName("Test for Jenkins")
public class PositiveTest3 {

    @Test
    @DisplayName("Test : Delete pet with primary parameters")
    @Description("Delete pet, check that response will be null")
    public void deleteTest() {

        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add(RandomStringUtils.randomAlphanumeric(6));

        PetModel pet = new PetModel();
        pet.setId(RandomUtils.nextInt(0,9000));
        pet.setPhotoUrls(stringArrayList);
        pet.setName("PetMy");
        pet.setStatus(PetStatus.available.name());

        String petId = String.valueOf(pet.getId());

        PetController petController = new PetController();
        petController.addNewPet(pet);
        petController.deletePet(petId);

        BadResponse petActualResponse = (BadResponse) petController.getPetById(petId);

        BadResponse expectedResponse = new BadResponse(1, "error", "Pet not found");

        BadResponseAssert.assertThat(petActualResponse).isEqualToComparingFieldByFieldRecursively(expectedResponse);
    }
}
