package io.swagger.petstore.order.get_list_inventory;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.OrderTestsCategory;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.controllers.order.OrderController;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, OrderTestsCategory.class})
@Feature("Order tests : Positive")
@Story("Get inventory list")
@DisplayName("Get inventory list")
public class GetListInventoryTest {

    @Test
    @DisplayName("Test : Get inventory list")
    @Description("Get inventory list and check that status code will be 200")
    public void getListInventory() {

        String response = new OrderController().getListInventory();
        printResponse(response);
    }

    @Step("Print list inventory response")
    private void printResponse(String response) {
        System.out.println(response);
    }
}
