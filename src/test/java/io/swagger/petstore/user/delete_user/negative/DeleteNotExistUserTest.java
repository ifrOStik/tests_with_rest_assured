package io.swagger.petstore.user.delete_user.negative;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.category.NegativeCategory;
import io.swagger.petstore.category.UserTestsCategory;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import io.swagger.petstore.user.UserDataGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, UserTestsCategory.class})
@Feature("User tests : Negative")
@Story("Delete a non-existent user")
@DisplayName("Delete a non-existent user")
public class DeleteNotExistUserTest extends UserDataGenerator {

    @Test
    @DisplayName("Test : Delete a non-existent user")
    @Description("Delete a non-existent user, check that response will be 404 error")
    public void deleteNotExistTest() {

        UserModel user = userModelGenerator();

        UserController userController = new UserController();
        userController.deleteUser(user);
    }
}
