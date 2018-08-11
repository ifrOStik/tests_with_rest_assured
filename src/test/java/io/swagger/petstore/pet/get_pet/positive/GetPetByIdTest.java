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

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);

        PetModel petRequest = (PetModel) petController.getPetById(pet);
        PetModelAssert.assertThat(petRequest).isEqualTo(pet);
    }
}
