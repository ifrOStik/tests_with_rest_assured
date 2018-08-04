package io.swagger.petstore.pet.add_pet.negative;

import io.swagger.petstore.assertions.pet.PetBadResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetBadResponse;
import org.junit.Test;

public class BadRequestAddPetTest {

    @Test
    public void badRequestTest() {

        PetBadResponse request = new  PetController().badRequest();

        PetBadResponseAssert.assertThat(request)
                .hasCode(400)
                .hasMessage("bad input")
                .hasType("unknown");
    }
}
