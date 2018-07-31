package io.swagger.petstore.pet.add_pet.negative;

import io.swagger.petstore.assertions.pet.PetFailResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetFailResponse;
import org.junit.Test;

public class ServerErrorTest {

    @Test
    public void serverErrorTest() {

        PetFailResponse request = new PetController().serverErrorRequest();

        PetFailResponseAssert.assertThat(request)
                .hasCode(500)
                .hasMessage("something bad happened")
                .hasType("unknown");
    }
}
