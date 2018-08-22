package io.swagger.petstore.order.get_order.negative;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.NegativeCategory;
import io.swagger.petstore.category.OrderTestsCategory;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, OrderTestsCategory.class})
@Feature("Order tests : Negative")
@Story("Get a non-existent order")
@DisplayName("Get a non-existent order")
public class GetNotExistOrderTest extends OrderDataGenerator {

    @Test
    @DisplayName("Test : Get a non-existent order")
    @Description("Get a non-existent order, check that response will be 404 error")
    public void getOrderTest() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController();

        BadResponse actualOrderResponse = (BadResponse) orderController.getOrder(String.valueOf(order.getId()));
        BadResponse expectedResponse = new BadResponse(1, "error", "Order not found");

        checkErrorResponse(actualOrderResponse, expectedResponse);
    }
}
