package io.swagger.petstore.pet.add_pet.negative;

import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import org.junit.Test;

public class BadRequestAddPetTest {

    @Test
    public void badRequestTest() {

        BadResponse response = new  PetController().badRequest();

        BadResponseAssert.assertThat(response)
                .hasCode(400)
                .hasMessage("bad input")
                .hasType("unknown");
    }
}
