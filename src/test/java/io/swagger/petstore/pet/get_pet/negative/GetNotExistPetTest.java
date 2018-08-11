package io.swagger.petstore.pet.get_pet.negative;

import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;

public class GetNotExistPetTest extends PetDataGenerator {

    @Test
    public void getNotExistTest() {

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);
        petController.deletePet(pet);

        BadResponse petResponse = (BadResponse) petController.getPetById(pet);

        BadResponseAssert.assertThat(petResponse)
                .hasCode(1)
                .hasType("error")
                .hasMessage("Pet not found");
    }
}
