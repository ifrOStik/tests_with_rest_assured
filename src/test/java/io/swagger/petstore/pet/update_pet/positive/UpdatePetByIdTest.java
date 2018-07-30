package io.swagger.petstore.pet.update_pet.positive;

import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;


public class UpdatePetByIdTest extends PetDataGenerator {

    @Test
    public void updatePetTest() {

        PetModel testPet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController(testPet);
        petController.addNewPet();

        testPet.setStatus(PetStatus.sold.name());
        testPet.setName(petNameGenerator());
        testPet.setId(petIdGenerator());

        petController.updatePetById();

        PetModel petResponse = (PetModel) petController.getPetById();
        PetModelAssert.assertThat(petResponse).isEqualTo(testPet);
    }
}
