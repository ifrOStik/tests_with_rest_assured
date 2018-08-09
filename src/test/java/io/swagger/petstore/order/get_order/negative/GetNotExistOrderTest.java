package io.swagger.petstore.order.get_order.negative;

import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;

public class GetNotExistOrderTest extends OrderDataGenerator {

    @Test
    public void getOrderTest() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController(order);

        BadResponse responseOrder = (BadResponse) orderController.getOrder();

        BadResponseAssert.assertThat(responseOrder)
                .hasCode(1)
                .hasType("error")
                .hasMessage("Order not found");
    }
}
