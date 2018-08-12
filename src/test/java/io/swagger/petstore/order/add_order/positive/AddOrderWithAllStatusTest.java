package io.swagger.petstore.order.add_order.positive;

import io.swagger.petstore.assertions.order.OrderModelAssert;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import io.swagger.petstore.utils.OrderStatus;
import org.junit.Test;

public class AddOrderWithAllStatusTest extends OrderDataGenerator {

    @Test
    public  void addOrder1() {
        test(OrderStatus.placed);
    }

    @Test
    public void addOrder2() {
        test(OrderStatus.delivered);
    }

    @Test
    public void addOrder3() {
        test(OrderStatus.approved);
    }

    private void test(OrderStatus orderStatus) {

        OrderModel order = orderModelGenerator(orderStatus);

        OrderController orderController = new OrderController();
        OrderModel response = orderController.addOrder(order);

        OrderModelAssert.assertThat(response)
                .hasId(order.getId())
                .hasPetId(order.getPetId())
                .hasQuantity(order.getQuantity())
                .hasStatus(order.getStatus());
    }
}
