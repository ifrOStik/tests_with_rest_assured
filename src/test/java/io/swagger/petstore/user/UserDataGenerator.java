package io.swagger.petstore.user;

import io.qameta.allure.Step;
import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.assertions.user.UserModelAssert;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.user.UserModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class UserDataGenerator {

    public int generateUserId() {
        return RandomUtils.nextInt(0,9000);
    }

    public String generateFirstName() {
        return "first_name_" + RandomStringUtils.randomAlphanumeric(6);
    }

    public String generateLastName() {
        return "last_name_" + RandomStringUtils.randomAlphanumeric(6);
    }

    public String generateUserName() {
        return "user_name_" + RandomStringUtils.randomAlphanumeric(6);
    }

    public String generateEmail() {
        return "new_email_" + RandomStringUtils.randomAlphanumeric(9) + "@mail.com";
    }

    public String generatePhone() {
        return "user_phone_" + RandomStringUtils.randomNumeric(9);
    }

    public String generatePassword() {
        return "user_password_" + RandomStringUtils.randomAlphanumeric(6);
    }

    public int generateUserStatus() {
        return RandomUtils.nextInt(0,9);
    }

    @Step("Generate user with all parameters")
    public UserModel userModelGenerator() {

        UserModel userModel = new UserModel();
        userModel.setId(generateUserId());
        userModel.setLastName(generateLastName());
        userModel.setFirstName(generateFirstName());
        userModel.setUsername(generateUserName());
        userModel.setEmail(generateEmail());
        userModel.setPhone(generatePhone());
        userModel.setPassword(generatePassword());
        userModel.setUserStatus(generateUserStatus());

        return userModel;
    }

    @Step("Check expected and actual result")
    public void checkResultUserModel(UserModel actualResponse, UserModel expectedResult) {
        UserModelAssert.assertThat(actualResponse).isEqualTo(expectedResult);
    }

    @Step("Check expected and actual result")
    public void checkErrorResponse(BadResponse actualResult, BadResponse expectedResult) {
        BadResponseAssert.assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }
}
