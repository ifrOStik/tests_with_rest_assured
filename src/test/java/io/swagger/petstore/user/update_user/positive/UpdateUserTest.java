package io.swagger.petstore.user.update_user.positive;

import io.swagger.petstore.assertions.user.UserModelAssert;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;

public class UpdateUserTest extends UserDataGenerator {

    @Test
    public void updateUserTest() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController();
        userController.addUser(user);

        user.setEmail(generateEmail());
        user.setPhone(generatePhone());
        user.setLastName(generateLastName());

        userController.updateUser(user);

        UserModel userResponse = (UserModel) userController.getUser(user);

        UserModelAssert.assertThat(userResponse).isEqualTo(user);
    }
}