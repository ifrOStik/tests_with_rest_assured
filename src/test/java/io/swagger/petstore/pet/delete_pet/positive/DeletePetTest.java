package io.swagger.petstore.pet.delete_pet.positive;

import io.swagger.petstore.assertions.pet.PetFailResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetFailResponse;
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

        PetFailResponse petResponse = (PetFailResponse) petController.getPetById();

        PetFailResponseAssert.assertThat(petResponse)
                .hasCode(1)
                .hasType("error")
                .hasMessage("Pet not found");
    }
}
