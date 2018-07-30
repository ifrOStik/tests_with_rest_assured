package io.swagger.petstore.pet.add_pet.positive;

import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;

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

        PetModel testPet = petModelRandomGenerator(petStatus);

        PetModel petResponse = new PetController(testPet).addNewPet();
        PetModelAssert.assertThat(petResponse).isEqualTo(testPet);
    }
}
