package io.swagger.petstore.order.get_order.positive;

import io.swagger.petstore.assertions.order.OrderModelAssert;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;

public class GetOrderTest extends OrderDataGenerator {

    @Test
    public void getOrderTest() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController(order);
        orderController.addOrder();

        OrderModel responseOrder = (OrderModel) orderController.getOrder();

        OrderModelAssert.assertThat(responseOrder)
                .hasStatus(order.getStatus())
                .hasQuantity(order.getQuantity())
                .hasPetId(order.getPetId())
                .hasId(order.getId());
    }
}
