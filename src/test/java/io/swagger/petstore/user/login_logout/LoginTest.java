package io.swagger.petstore.user.login_logout;

import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;

public class LoginTest extends UserDataGenerator {

        @Test
        public void test() {

            UserModel user = userModelGenerator();

            UserController userController = new UserController();
            userController.addUser(user);

            userController.loginUser(user);
        }
}
