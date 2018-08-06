package io.swagger.petstore.pet.add_pet.negative;

import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import org.junit.Test;

public class ServerErrorTest {

    @Test
    public void serverErrorTest() {

        BadResponse request = new PetController().serverErrorRequest();

        BadResponseAssert.assertThat(request)
                .hasCode(500)
                .hasMessage("something bad happened")
                .hasType("unknown");
    }
}
