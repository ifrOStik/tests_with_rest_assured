package io.swagger.petstore.order.add_order.negative;

import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.bad_response.BadResponse;
import org.junit.Test;

public class InvalidInputAddOrderTest {

    @Test
    public void invalidInputTest() {

        BadResponse response = new OrderController().addOrderInvalidInput();

        BadResponseAssert.assertThat(response)
                .hasCode(400)
                .hasMessage("bad input")
                .hasType("unknown");
    }
}
