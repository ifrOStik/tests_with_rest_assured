package io.swagger.petstore.order.get_order.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.OrderTestsCategory;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, OrderTestsCategory.class})
@Feature("Order tests : Positive")
@Story("Get order")
@DisplayName("Get order")
public class GetOrderTest extends OrderDataGenerator {

    @Test
    @DisplayName("Test : Get order")
    @Description("Get order and check that response order object is equal to the created order")
    public void getOrderTest() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController();
        orderController.addOrder(order);

        OrderModel actualOrderResponse = (OrderModel) orderController.getOrder(order);

        checkResultOrderModel(actualOrderResponse, order);
    }
}
