package io.swagger.petstore.user.add_user.positive;

import io.swagger.petstore.assertions.user.UserModelAssert;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;


public class CreateUsersArrayTest extends UserDataGenerator {

    @Test
    public void addArrayUsersTest() {

        UserModel user1 = userModelGenerator();
        UserModel user2 = userModelGenerator();
        UserModel user3 = userModelGenerator();

        UserModel[] userModels = new UserModel[3];
        userModels[0] = user1;
        userModels[1] = user2;
        userModels[2] = user3;

        UserController userController = new UserController();
        userController.addUsersArray(userModels);

        UserModel responseUser1 = (UserModel) userController.getUser(user1);
        UserModel responseUser2 = (UserModel) userController.getUser(user2);
        UserModel responseUser3 = (UserModel) userController.getUser(user3);

        UserModelAssert.assertThat(responseUser1).isEqualTo(user1);
        UserModelAssert.assertThat(responseUser2).isEqualTo(user2);
        UserModelAssert.assertThat(responseUser3).isEqualTo(user3);
    }
}
