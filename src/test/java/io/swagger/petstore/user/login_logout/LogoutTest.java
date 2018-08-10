package io.swagger.petstore.user.login_logout;

import io.swagger.petstore.controllers.user.UserController;
import org.junit.Test;

public class LogoutTest {

    @Test
    public void logoutTest() {

        new UserController().logoutUser();
    }
}
