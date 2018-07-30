package io.swagger.petstore.pet.update_pet.negative;

import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.utils.PetStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;


public class UpdateNotFoundTest {

    @Test
    public void notFoundPetTest() {

        int petId = RandomUtils.nextInt(0, 9000);
        String petName = RandomStringUtils.randomAlphanumeric(6);

        PetModel testPet = new PetModel(null, petName, petId, null, null,
                PetStatus.available.name());

        PetController petController = new PetController(testPet);

        PetModel petResponse = petController.updatePet(404);

        PetModelAssert.assertThat(petResponse).isEqualTo(testPet);
    }
}
