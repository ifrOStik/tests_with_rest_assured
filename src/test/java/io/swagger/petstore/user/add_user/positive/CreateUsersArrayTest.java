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
@Story("Create new user array")
@DisplayName("Create new user array")
public class CreateUsersArrayTest extends UserDataGenerator {

    @Test
    @DisplayName("Test : Create new user array")
    @Description("Create new user array and check that response user is equals created user")
    public void addArrayUsersTest() {

        UserModel user1 = userModelGenerator();
        UserModel user2 = userModelGenerator();
        UserModel user3 = userModelGenerator();

        UserModel[] userModels = new UserModel[3];
        userModels[0] = user1;
        userModels[1] = user2;
        userModels[2] = user3;

        UserController userController = new UserController();
        userController.addUsersArray(userModels);

        UserModel actualUser1Response = (UserModel) userController.getUser(user1.getUsername());
        UserModel actualUser2Response = (UserModel) userController.getUser(user2.getUsername());
        UserModel actualUser3Response = (UserModel) userController.getUser(user3.getUsername());

        checkResultUserModel(actualUser1Response, user1);
        checkResultUserModel(actualUser2Response, user2);
        checkResultUserModel(actualUser3Response, user3);
    }
}
