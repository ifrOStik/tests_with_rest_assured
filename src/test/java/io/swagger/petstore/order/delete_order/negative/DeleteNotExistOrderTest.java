package io.swagger.petstore.order.delete_order.negative;

import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;

public class DeleteNotExistOrderTest extends OrderDataGenerator {

    @Test
    public void deleteNotExistTest() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController(order);
        orderController.deleteOrder();
        orderController.deleteOrder();
    }
}
