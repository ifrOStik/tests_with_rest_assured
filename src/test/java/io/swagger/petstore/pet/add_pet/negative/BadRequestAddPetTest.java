package io.swagger.petstore.pet.add_pet.negative;

import io.swagger.petstore.assertions.pet.PetFailResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.models.pet.PetFailResponse;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;

public class BadRequestAddPetTest extends PetDataGenerator {

    @Test
    public void test() {

        PetModel testPet = new PetModel(petPhotoUrlGenerator(), petNameGenerator(), petIdGenerator(),
                null, null, PetStatus.available.name());

        PetFailResponse request = new  PetController(testPet).badRequest();

        PetFailResponseAssert.assertThat(request)
                .hasCode(400)
                .hasMessage("bad input")
                .hasType("unknown");
    }
}
