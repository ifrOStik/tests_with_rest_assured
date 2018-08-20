package io.swagger.petstore.user.get_user.negative;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.NegativeCategory;
import io.swagger.petstore.category.UserTestsCategory;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, UserTestsCategory.class})
@Feature("User tests : Negative")
@Story("Get a non-existent user")
@DisplayName("Get a non-existent user")
public class GetNotExistUserTest extends UserDataGenerator {

    @Test
    @DisplayName("Test : Get a non-existent user")
    @Description("Get a non-existent user, check that response will be 404 error")
    public void getNotExistUser() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController();

        BadResponse actualUserResponse = (BadResponse) userController.getUser(user);
        BadResponse expectedResponse = new BadResponse(1, "error", "User not found");

        checkErrorResponse(actualUserResponse, expectedResponse);
    }
 }
