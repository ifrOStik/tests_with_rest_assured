package io.swagger.petstore.pet.add_pet.negative;

import io.swagger.petstore.assertions.pet.PetFailResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetFailResponse;
import org.junit.Test;

public class BadRequestAddPetTest {

    @Test
    public void badRequestTest() {

        PetFailResponse request = new  PetController().badRequest();

        PetFailResponseAssert.assertThat(request)
                .hasCode(400)
                .hasMessage("bad input")
                .hasType("unknown");
    }
}