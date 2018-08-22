package io.swagger.petstore.user.update_user.positive;

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
@Story("Update user")
@DisplayName("Update user")
public class UpdateUserTest extends UserDataGenerator {

    @Test
    @DisplayName("Test : Update user")
    @Description("Update user and check that response user is equals updated user")
    public void updateUserTest() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController();
        userController.addUser(user);

        user.setEmail(generateEmail());
        user.setPhone(generatePhone());
        user.setLastName(generateLastName());

        userController.updateUser(user);

        UserModel actualUserResponse = (UserModel) userController.getUser(user.getUsername());

        checkResultUserModel(actualUserResponse, user);
    }
}
