package io.swagger.petstore.jenkins;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.assertions.user.UserModelAssert;
import io.swagger.petstore.category.JenkinsCategory;
import io.swagger.petstore.controllers.user.UserController;
import io.swagger.petstore.models.user.UserModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JenkinsCategory.class)
@Feature("User tests : Negative")
@Story("Jenkins")
@DisplayName("Test for Jenkins")
public class NegativeTest {

    @Test
    @DisplayName("Test : Create new user")
    @Description("Create new user and check that response user is equals created user")
    public void addUser() {

        UserModel userModel = new UserModel();
        userModel.setEmail("test@test.com");
        userModel.setFirstName("Fedor" + RandomStringUtils.randomAlphanumeric(2));
        userModel.setId(RandomUtils.nextInt(0, 9000));
        userModel.setLastName("Ust" + RandomStringUtils.randomAlphanumeric(3));
        userModel.setPassword("qwerty");
        userModel.setPhone("+89545678989");
        userModel.setUsername("Test");
        userModel.setUserStatus(RandomUtils.nextInt(0, 9));

        UserController userController = new UserController();
        userController.addUser(userModel);

        UserModel actualUserResponse = (UserModel) userController.getUser(userModel.getUsername());
        userModel.setUsername("sadasdasd");

        UserModelAssert.assertThat(actualUserResponse).isEqualToComparingFieldByFieldRecursively(userModel);
    }
}
