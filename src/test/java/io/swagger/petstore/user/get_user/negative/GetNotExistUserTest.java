package io.swagger.petstore.user.get_user.negative;

import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;

public class GetNotExistUserTest extends UserDataGenerator {

    @Test
    public void getNotExistUser() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController();
        BadResponse userResponse = (BadResponse) userController.getUser(user);

        BadResponseAssert.assertThat(userResponse)
                .hasCode(1)
                .hasType("error")
                .hasMessage("User not found");
    }
 }
