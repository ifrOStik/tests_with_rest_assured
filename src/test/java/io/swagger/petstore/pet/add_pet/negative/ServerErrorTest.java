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
@Story("Отправка невелидного запроса, c ошибочными параметрами")
@DisplayName("Отправка невелидного запроса, c ошибочными параметрами")
public class ServerErrorTest {

    @Test
    @DisplayName("Тест : Проверка 500 ответа")
    @Description("Тестовая проверка")
    public void serverErrorTest() {

        BadResponse request = new PetController().serverErrorRequest();

        BadResponseAssert.assertThat(request)
                .hasCode(500)
                .hasMessage("something bad happened")
                .hasType("unknown");
    }
}
