package io.swagger.petstore.pet.add_pet.positive;

import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;


public class AddPetWithAllStatusTest extends PetDataGenerator {

    @Test
    public void addNewPetAvailableStatus() {
        test(PetStatus.available);
    }

    @Test
    public void addNewPetPendingStatus() {
        test(PetStatus.pending);
    }

    @Test
    public void addNewPetSoldStatus() {
        test(PetStatus.sold);
    }

    private void test(PetStatus petStatus) {

        PetModel pet = petModelRandomGenerator(petStatus);

        PetModel petResponse = new PetController().addNewPet(pet);

        PetModelAssert.assertThat(petResponse).isEqualTo(pet);
    }
}
