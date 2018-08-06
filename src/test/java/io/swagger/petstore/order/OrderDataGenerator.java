package io.swagger.petstore.order;

import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.order.OrderModel;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.utils.OrderStatus;
import io.swagger.petstore.utils.PetStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderDataGenerator {

    public int orderIdGenerator() {
        return RandomUtils.nextInt(0,9000);
    }

    public int quantityGenerator() {
        return RandomUtils.nextInt(0,9);
    }

    public String shipDateGenerator() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSZ");
        Date newDate = new Date();
        return dateFormat.format(newDate);
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

    public OrderModel orderModelGenerator(int petId) {

        OrderModel order = new OrderModel();
        order.setId(orderIdGenerator());
        order.setPetId(petId);
        order.setQuantity(quantityGenerator());
        order.setShipDate(shipDateGenerator());
        order.setStatus(statusOrderGenerator());
        order.setComplete(statusCompleteGenerator());

        return order;
    }

    public OrderModel orderModelGenerator(int petId, OrderStatus orderStatus, boolean statusComplete) {

        OrderModel order = new OrderModel();
        order.setId(orderIdGenerator());
        order.setPetId(petId);
        order.setQuantity(quantityGenerator());
        order.setShipDate(shipDateGenerator());
        order.setStatus(orderStatus.name());
        order.setComplete(statusComplete);

        return order;
    }

    public OrderModel orderModelGeneratorWithPet() {

        PetModel petModel = new PetModel();
        petModel.setId(RandomUtils.nextInt(0,9000));
        petModel.setName(RandomStringUtils.randomAlphanumeric(6));
        petModel.setStatus(PetStatus.available.name());

        new PetController(petModel).addNewPet();

        return orderModelGenerator(petModel.getId());

    }
}
