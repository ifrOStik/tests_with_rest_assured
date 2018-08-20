package io.swagger.petstore.order.add_order.negative;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.NegativeCategory;
import io.swagger.petstore.category.OrderTestsCategory;
import io.swagger.petstore.controllers.order.OrderController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.order.OrderDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, OrderTestsCategory.class})
@Feature("Order tests : Negative")
@Story("Sending a invalid request, without one parameter")
@DisplayName("Sending a invalid request, without one parameter")
public class InvalidInputAddOrderTest extends OrderDataGenerator {

    @Test
    @DisplayName("Test : Sending a invalid request, without parameter")
    @Description("Sending a invalid request, check expected result the 400 error")
    public void invalidInputTest() {

        BadResponse actualPetResponse = new OrderController().addOrderInvalidInput();
        BadResponse expectedResponse = new BadResponse(400, "unknown", "bad input");

        checkErrorResponse(actualPetResponse, expectedResponse);
    }
}
