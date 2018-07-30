package io.swagger.petstore.pet.get_pet.positive;

import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;


public class GetPetByIdTest extends PetDataGenerator {

    @Test
    public void getPetById() {

        PetModel testPet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController(testPet);
        petController.addNewPet();

        PetModel petRequest = (PetModel) petController.getPetById();
        PetModelAssert.assertThat(petRequest).isEqualTo(testPet);
    }
}
