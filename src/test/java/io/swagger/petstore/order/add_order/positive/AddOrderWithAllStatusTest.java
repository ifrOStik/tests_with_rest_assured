package io.swagger.petstore.order.add_order.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.OrderTestsCategory;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import io.swagger.petstore.utils.OrderStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, OrderTestsCategory.class})
@Feature("Order tests : Positive")
@Story("Create order with all status")
@DisplayName("Create order with all status")
public class AddOrderWithAllStatusTest extends OrderDataGenerator {

    @Test
    @DisplayName("Test : Create order in the PLACED status")
    @Description("Create order in the PLACED status and check the returned order object")
    public  void createPlacedOrder() {
        test(OrderStatus.placed);
    }

    @Test
    @DisplayName("Test : Create order in the DELIVERED status")
    @Description("Create order in the DELIVERED status and check the returned order object")
    public void createDeliveredOrder() {
        test(OrderStatus.delivered);
    }

    @Test
    @DisplayName("Test : Create order in the APPROVED status")
    @Description("Create order in the APPROVED status and check the returned order object")
    public void createApprovedOrder() {
        test(OrderStatus.approved);
    }

    private void test(OrderStatus orderStatus) {

        OrderModel order = orderModelGenerator(orderStatus);

        OrderController orderController = new OrderController();
        OrderModel actualOrderResponse = orderController.addOrder(order);

        checkResultOrderModel(actualOrderResponse, order);
    }
}
