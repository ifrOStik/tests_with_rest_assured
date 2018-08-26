package io.swagger.petstore.order;

import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;
import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.assertions.order.OrderModelAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.utils.OrderStatus;
import io.swagger.petstore.utils.PetStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;

import java.util.Random;

public class OrderDataGenerator {

    public int orderIdGenerator() {
        return RandomUtils.nextInt(0,9000);
    }

    public int quantityGenerator() {
        return RandomUtils.nextInt(0,9);
    }

    public String statusOrderGenerator() {

        Random random=new Random();
        String randomStatus;

        String statusList[] = new String[3];
        statusList[0] = OrderStatus.approved.name();
        statusList[1] = OrderStatus.delivered.name();
        statusList[2] = OrderStatus.placed.name();

        return randomStatus = statusList[random.nextInt(3)];
    }

    public boolean statusCompleteGenerator() {

        Random random = new Random();
        boolean randomComplete;

        return randomComplete = random.nextBoolean();
    }

    @Step("Generate order without pet")
    public OrderModel orderModelGenerator(int petId) {

        OrderModel order = new OrderModel();
        order.setId(orderIdGenerator());
        order.setPetId(petId);
        order.setQuantity(quantityGenerator());
        order.setStatus(statusOrderGenerator());
        order.setComplete(statusCompleteGenerator());

        return order;
    }

    @Step("Generate order without pet")
    public OrderModel orderModelGenerator(int petId, OrderStatus orderStatus, boolean statusComplete) {

        OrderModel order = new OrderModel();
        order.setId(orderIdGenerator());
        order.setPetId(petId);
        order.setQuantity(quantityGenerator());
        order.setStatus(orderStatus.name());
        order.setComplete(statusComplete);

        return order;
    }

    @Step("Generate order with pet")
    public OrderModel orderModelGeneratorWithPet() {

        PetModel petModel = new PetModel();
        petModel.setId(RandomUtils.nextInt(0,9000));
        petModel.setName(RandomStringUtils.randomAlphanumeric(6));
        petModel.setStatus(PetStatus.available.name());

        new PetController().addNewPet(petModel);

        OrderModel order = new OrderModel();
        order.setId(orderIdGenerator());
        order.setPetId(petModel.getId());
        order.setQuantity(quantityGenerator());
        order.setStatus(statusOrderGenerator());
        order.setComplete(statusCompleteGenerator());

        return order;
    }

    @Step("Generate order with primary parameters")
    public OrderModel orderModelGenerator(OrderStatus orderStatus) {

        PetModel petModel = new PetModel();
        petModel.setId(RandomUtils.nextInt(0,9000));
        petModel.setName(RandomStringUtils.randomAlphanumeric(6));
        petModel.setStatus(PetStatus.available.name());

        OrderModel order = new OrderModel();
        order.setId(orderIdGenerator());
        order.setPetId(petModel.getId());
        order.setQuantity(quantityGenerator());
        order.setStatus(orderStatus.name());
        order.setComplete(statusCompleteGenerator());

        return order;
    }

    @Step("Check expected and actual result")
    public void checkResultOrderModel(OrderModel actualResponse, OrderModel expectedResult) {
        OrderModelAssert.assertThat(actualResponse).isEqualTo(expectedResult);
    }

    @Step("Check expected and actual result")
    public void checkErrorResponse(BadResponse actualResult, BadResponse expectedResult) {
        BadResponseAssert.assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }

    @Step("Check expected and actual result")
    public void checkNotExistOrderResponse(ResponseBody actualResponse, String expectedResponse) {
        Assert.assertEquals(expectedResponse, actualResponse.prettyPrint());
    }
}
