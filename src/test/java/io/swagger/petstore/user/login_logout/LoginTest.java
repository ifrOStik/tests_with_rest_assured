package io.swagger.petstore.user.login_logout;

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
@Story("Login user")
@DisplayName("Login user")
public class LoginTest extends UserDataGenerator {

        @Test
        @DisplayName("Test : Login user")
        @Description("Login user and check that status code will ne equals 200")
        public void test() {

            UserModel user = userModelGenerator();

            UserController userController = new UserController();
            userController.addUser(user);

            userController.loginUser(user);
        }
}
