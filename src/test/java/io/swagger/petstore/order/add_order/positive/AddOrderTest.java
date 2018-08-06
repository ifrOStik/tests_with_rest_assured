package io.swagger.petstore.order.add_order.positive;

import io.swagger.petstore.assertions.order.OrderModelAssert;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;

public class AddOrderTest extends OrderDataGenerator {

    @Test
    public void addNewOrder() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController(order);
        OrderModel response = orderController.addOrder();

        OrderModelAssert.assertThat(response)
                .hasId(order.getId())
                .hasPetId(order.getPetId())
                .hasQuantity(order.getQuantity())
                .hasStatus(order.getStatus());
    }
}
