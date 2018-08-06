package io.swagger.petstore.order.get_list_inventory;

import io.swagger.petstore.controllers.order.OrderController;
import org.junit.Test;

public class GetListInventoryTest {

    @Test
    public void getListInventory() {

        new OrderController().getListInventory();
    }
}
