package io.swagger.petstore.user.get_user.positive;

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
@Story("Get user")
@DisplayName("Get user")
public class GetUserTest extends UserDataGenerator {

    @Test
    @DisplayName("Test : Get user")
    @Description("Get user and check that response user object is equal to the created user")
    public void getUserTest() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController();
        userController.addUser(user);

        UserModel actualUserResponse = (UserModel) userController.getUser(user);

        checkResultUserModel(actualUserResponse, user);
    }
}
