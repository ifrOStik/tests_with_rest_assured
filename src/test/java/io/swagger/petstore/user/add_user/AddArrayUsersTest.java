package io.swagger.petstore.user.add_user;

import io.swagger.petstore.assertions.user.UserModelAssert;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;


public class AddArrayUsersTest extends UserDataGenerator {

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

        UserModel responseUser1 = userController.getUserByName(user1.getUsername());
        UserModel responseUser2 = userController.getUserByName(user2.getUsername());
        UserModel responseUser3 = userController.getUserByName(user3.getUsername());

        UserModelAssert.assertThat(responseUser1).isEqualTo(user1);
        UserModelAssert.assertThat(responseUser2).isEqualTo(user2);
        UserModelAssert.assertThat(responseUser3).isEqualTo(user3);
    }
}