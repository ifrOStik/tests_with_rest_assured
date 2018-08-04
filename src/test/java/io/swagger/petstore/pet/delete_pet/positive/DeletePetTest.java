package io.swagger.petstore.pet.delete_pet.positive;

import io.swagger.petstore.assertions.pet.PetBadResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetBadResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;


public class DeletePetTest extends PetDataGenerator {

    @Test
    public void deleteTest() {

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
