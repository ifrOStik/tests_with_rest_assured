package io.swagger.petstore.pet.get_pet.negative;

import io.swagger.petstore.assertions.pet.PetFailResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetFailResponse;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;


public class GetNotFondPetTest extends PetDataGenerator {

    @Test
    public void getNotFoundPet() {

        PetModel testPet = petModelRandomGenerator(PetStatus.available);

        PetFailResponse petRequest = (PetFailResponse)
                new PetController(testPet).getPetById();

        PetFailResponseAssert.assertThat(petRequest)
                .hasCode(1)
                .hasType("error")
                .hasMessage("Pet not found");
    }
}
