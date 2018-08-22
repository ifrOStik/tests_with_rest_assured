package io.swagger.petstore.order.delete_order.negative;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.NegativeCategory;
import io.swagger.petstore.category.OrderTestsCategory;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, OrderTestsCategory.class})
@Feature("Order tests : Negative")
@Story("Delete a non-existent order")
@DisplayName("Delete a non-existent order")
public class DeleteNotExistOrderTest extends OrderDataGenerator {

    @Test
    @DisplayName("Test : Delete a non-existent order")
    @Description("Delete a non-existent order, check that response will be 404 error")
    public void deleteNotExistTest() {

        OrderModel order = orderModelGeneratorWithPet();

        OrderController orderController = new OrderController();
        orderController.deleteOrder(String.valueOf(order.getId()));
    }
}
