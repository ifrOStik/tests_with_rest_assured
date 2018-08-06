package io.swagger.petstore.order.delete_order.positive;

import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;

public class DeleteOrderTest extends OrderDataGenerator {

    @Test
    public void deleteOrderTest() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController(order);
        orderController.addOrder();
        orderController.deleteOrder();

        BadResponse responseOrder = (BadResponse) orderController.getOrder();

        BadResponseAssert.assertThat(responseOrder)
                .hasCode(1)
                .hasType("error")
                .hasMessage("Order not found");
    }
}
