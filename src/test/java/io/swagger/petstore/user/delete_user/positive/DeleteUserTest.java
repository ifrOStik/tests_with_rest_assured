package io.swagger.petstore.user.delete_user.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.category.UserTestsCategory;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, UserTestsCategory.class})
@Feature("User tests : Positive")
@Story("Delete user")
@DisplayName("Delete user")
public class DeleteUserTest extends UserDataGenerator {

    @Test
    @DisplayName("Test : Delete user")
    @Description("Delete user, check that response will be null and message \"User not found\"")
    public void deleteUserTest() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController();
        userController.addUser(user);
        userController.deleteUser(user);

        BadResponse actualUserResponse = (BadResponse) userController.getUser(user);
        BadResponse expectedResponse = new BadResponse(1, "error", "User not found");

        checkErrorResponse(actualUserResponse, expectedResponse);
    }
}
