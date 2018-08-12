package io.swagger.petstore.user.delete_user.negative;

import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;

public class DeleteNotExistUserTest extends UserDataGenerator {

    @Test
    public void deleteNotExistTest() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController();
        userController.deleteUser(user);
    }
}
