package io.swagger.petstore.order.delete_order.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.OrderTestsCategory;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, OrderTestsCategory.class})
@Feature("Order tests : Positive")
@Story("Delete order")
@DisplayName("Delete order")
public class DeleteOrderTest extends OrderDataGenerator {

    @Test
    @DisplayName("Test : Delete order")
    @Description("Delete order, check that response will be null and message \"Order not found\"")
    public void deleteOrderTest() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController();
        orderController.addOrder(order);
        orderController.deleteOrder(order);

        BadResponse actualOrderResponse = (BadResponse) orderController.getOrder(order);
        BadResponse expectedResponse = new BadResponse(1, "error", "Order not found");

        checkErrorResponse(actualOrderResponse, expectedResponse);
    }
}
