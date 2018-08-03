package io.swagger.petstore.user.add_user;

import io.swagger.petstore.assertions.user.UserModelAssert;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Assert;
import org.junit.Test;

public class AddUsersTest extends UserDataGenerator {

    @Test
    public void addUser() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController(user);
        userController.addUser();

        UserModel response = userController.getUser();

        UserModelAssert.assertThat(response).isEqualTo(user);
    }

    @Test
    public void test() {

        UserController userController = new UserController();

        int userSession = userController.login("string", "string");

        Assert.assertEquals(userSession, int.class);
    }
}
