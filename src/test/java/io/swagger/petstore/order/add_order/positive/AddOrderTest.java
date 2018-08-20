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
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, OrderTestsCategory.class})
@Feature("Order tests : Positive")
@Story("Create order")
@DisplayName("Create order")
public class AddOrderTest extends OrderDataGenerator {

    @Test
    @DisplayName("Test : Create pet order")
    @Description("Create order and check that response order equals created order")
    public void addNewOrder() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController();
        OrderModel actualOrderResponse = orderController.addOrder(order);

        checkResultOrderModel(actualOrderResponse, order);
    }
}
