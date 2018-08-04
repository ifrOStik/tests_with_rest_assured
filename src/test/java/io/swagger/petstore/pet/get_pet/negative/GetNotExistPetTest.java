package io.swagger.petstore.pet.get_pet.negative;

import io.swagger.petstore.assertions.pet.PetBadResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetBadResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;

public class GetNotExistPetTest extends PetDataGenerator {

    @Test
    public void getNotExistTest() {

        PetModel testPet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController(testPet);
        petController.addNewPet();
        petController.deletePet(200);

        PetBadResponse petResponse = (PetBadResponse) petController.getPetById();

        PetBadResponseAssert.assertThat(petResponse)
                .hasCode(1)
                .hasType("error")
                .hasMessage("Pet not found");
    }
}
