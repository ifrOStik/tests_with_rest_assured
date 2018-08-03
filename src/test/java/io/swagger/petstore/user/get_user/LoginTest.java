package io.swagger.petstore.user.get_user;

import io.swagger.petstore.controllers.user.UserController;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {

        @Test
        public void test() {

            UserController userController = new UserController();

            userController.loginUser("string2", "string2");
        }
}
