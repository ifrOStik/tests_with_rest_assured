package io.swagger.petstore.user.add_user.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.category.UserTestsCategory;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;

@Category({PositiveCategory.class, UserTestsCategory.class})
@Feature("User tests : Positive")
@Story("Create new user list")
@DisplayName("Create new user list")
public class CreateUsersListTest extends UserDataGenerator {

    @Test
    @DisplayName("Test : Create new user list")
    @Description("Create new user list and check that response user is equals created user")
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

        UserModel actualUser1Response = (UserModel) userController.getUser(user1.getUsername());
        UserModel actualUser2Response = (UserModel) userController.getUser(user2.getUsername());
        UserModel actualUser3Response = (UserModel) userController.getUser(user3.getUsername());

        checkResultUserModel(actualUser1Response, user1);
        checkResultUserModel(actualUser2Response, user2);
        checkResultUserModel(actualUser3Response, user3);
    }
}
