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

@Category({PositiveCategory.class, UserTestsCategory.class})
@Feature("User tests : Positive")
@Story("Create new user")
@DisplayName("Create new user")
public class CreateUserTest extends UserDataGenerator {

    @Test
    @DisplayName("Test : Create new user")
    @Description("Create new user and check that response user is equals created user")
    public void addUser() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController();
        userController.addUser(user);

        UserModel actualUserResponse = (UserModel) userController.getUser(user.getUsername());

        checkResultUserModel(actualUserResponse, user);
    }
}
