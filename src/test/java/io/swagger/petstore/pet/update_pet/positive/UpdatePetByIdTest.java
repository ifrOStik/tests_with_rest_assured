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

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);

        pet.setStatus(PetStatus.sold.name());
        pet.setName(petNameGenerator());
        pet.setId(petIdGenerator());

        petController.updatePetById(pet);

        PetModel petResponse = (PetModel) petController.getPetById(pet);
        PetModelAssert.assertThat(petResponse).isEqualTo(pet);
    }
}
