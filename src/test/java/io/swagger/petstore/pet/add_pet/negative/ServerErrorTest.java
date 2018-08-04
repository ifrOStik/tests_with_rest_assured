package io.swagger.petstore.pet.add_pet.negative;

import io.swagger.petstore.assertions.pet.PetBadResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetBadResponse;
import org.junit.Test;

public class ServerErrorTest {

    @Test
    public void serverErrorTest() {

        PetBadResponse request = new PetController().serverErrorRequest();

        PetBadResponseAssert.assertThat(request)
                .hasCode(500)
                .hasMessage("something bad happened")
                .hasType("unknown");
    }
}
