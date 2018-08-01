package io.swagger.petstore.user.get_user;

import io.swagger.petstore.assertions.user.UserModelAssert;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Assert;
import org.junit.Test;

public class GetUserTest extends UserDataGenerator {

    @Test
    public void getUserTest() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController(user);
        userController.addUser();

        UserModel responseUser = userController.getUser();

        UserModelAssert.assertThat(responseUser).isEqualTo(user);
    }
}
