package io.swagger.petstore.pet.add_pet.negative;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.category.NegativeCategory;
import io.swagger.petstore.category.PetTestsCategory;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.bad_response.BadResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({NegativeCategory.class, PetTestsCategory.class})
@Feature("Pet tests : Negative")
@Story("Отправка невелидного запроса, без параметра")
@DisplayName("Отправка невелидного запроса, без параметра")
public class BadRequestAddPetTest {

    @Test
    @DisplayName("Тест : Отправка невалидноно запроса")
    @Description("Отправка невалидноно запроса, проверка ожидаемого результиата 400 ошибка")
    public void badRequestTest() {

        BadResponse response = new  PetController().badRequest();

        BadResponseAssert.assertThat(response)
                .hasCode(400)
                .hasMessage("bad input")
                .hasType("unknown");
    }
}
