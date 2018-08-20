package io.swagger.petstore.user.login_logout;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.PositiveCategory;
import io.swagger.petstore.category.UserTestsCategory;
import io.swagger.petstore.controllers.user.UserController;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PositiveCategory.class, UserTestsCategory.class})
@Feature("User tests : Positive")
@Story("Logout user")
@DisplayName("Logout user")
public class LogoutTest {

    @Test
    @DisplayName("Test : Logout user")
    @Description("Logout user and check that status code will ne equals 200")
    public void logoutTest() {

        new UserController().logoutUser();
    }
}
