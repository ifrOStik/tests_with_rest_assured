package io.swagger.petstore.user.add_user;

import io.swagger.petstore.assertions.user.UserModelAssert;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;

import java.util.ArrayList;

public class AddListUsersTest extends UserDataGenerator {

    @Test
    public void addListUsers() {

        UserModel user1 = userModelGenerator();
        UserModel user2 = userModelGenerator();
        UserModel user3 = userModelGenerator();

        ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();
        userModelArrayList.add(user1);
        userModelArrayList.add(user2);
        userModelArrayList.add(user3);

        UserController userController = new UserController();
        userController.addUsersList(userModelArrayList);

        UserModel responseUser1 = userController.getUserByName(user1.getUsername());
        UserModel responseUser2 = userController.getUserByName(user2.getUsername());
        UserModel responseUser3 = userController.getUserByName(user3.getUsername());

        UserModelAssert.assertThat(responseUser1).isEqualTo(user1);
        UserModelAssert.assertThat(responseUser2).isEqualTo(user2);
        UserModelAssert.assertThat(responseUser3).isEqualTo(user3);
    }
}
