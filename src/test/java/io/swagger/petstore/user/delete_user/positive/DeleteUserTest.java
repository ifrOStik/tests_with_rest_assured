package io.swagger.petstore.user.delete_user.positive;

import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;

public class DeleteUserTest extends UserDataGenerator {

    @Test
    public void deleteUserTest() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController(user);
        userController.addUser();
        userController.deleteUser();

        BadResponse userResponse = (BadResponse) userController.getUser();

        BadResponseAssert.assertThat(userResponse)
                .hasCode(1)
                .hasType("error")
                .hasMessage("User not found");
    }
}
