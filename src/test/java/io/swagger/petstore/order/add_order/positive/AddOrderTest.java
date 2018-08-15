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

        OrderController orderController = new OrderController();
        OrderModel response = orderController.addOrder(order);

        OrderModelAssert.assertThat(response).isEqualTo(order);
    }
}
