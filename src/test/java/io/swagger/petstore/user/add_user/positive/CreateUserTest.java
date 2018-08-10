package io.swagger.petstore.user.add_user.positive;

import io.swagger.petstore.assertions.user.UserModelAssert;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;

public class CreateUserTest extends UserDataGenerator {

    @Test
    public void addUser() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController(user);
        userController.addUser();

        UserModel response = (UserModel) userController.getUser();

        UserModelAssert.assertThat(response).isEqualTo(user);
    }
}
