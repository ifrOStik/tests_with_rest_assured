package io.swagger.petstore.pet;

import io.qameta.allure.Step;
import io.swagger.petstore.assertions.bad_response.BadResponseAssert;
import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.models.bad_response.BadResponse;
import io.swagger.petstore.models.pet.Category;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.models.pet.TagsItem;
import io.swagger.petstore.utils.PetStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class PetDataGenerator {

    public String petNameGenerator() {
        return "pet_name_" + RandomStringUtils.randomAlphanumeric(6);
    }

    public int petIdGenerator() {
        return RandomUtils.nextInt(0,9000);
    }

    public ArrayList<String> petPhotoUrlGenerator() {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add(RandomStringUtils.randomAlphanumeric(6));
        return stringArrayList;
    }

    public Category petCategoryGenerator() {
        Category category = new Category();
        category.setId(RandomUtils.nextInt(0,9000));
        category.setName(RandomStringUtils.randomAlphanumeric(6));
        return category;
    }

    public ArrayList<TagsItem> petTagItemGenerator() {
        TagsItem tagsItem = new TagsItem();
        tagsItem.setId(RandomUtils.nextInt(0,9000));
        tagsItem.setName(RandomStringUtils.randomAlphanumeric(6));

        ArrayList<TagsItem> tagsItemList = new ArrayList<TagsItem>();
        tagsItemList.add(tagsItem);
        return tagsItemList;
    }

    @Step("Generate pet with primary parameters")
    public PetModel petModelRandomGenerator(PetStatus petStatus) {
        PetModel petModel = new PetModel();
        petModel.setId(petIdGenerator());
        petModel.setPhotoUrls(petPhotoUrlGenerator());
        petModel.setName(petNameGenerator());
        petModel.setStatus(petStatus.name());
        return petModel;
    }

    @Step("Generate pet with all parameters")
    public PetModel petModelGeneratorWithAllParameters(PetStatus petStatus) {
        PetModel petModel = new PetModel();
        petModel.setId(petIdGenerator());
        petModel.setName(petNameGenerator());
        petModel.setPhotoUrls(petPhotoUrlGenerator());
        petModel.setCategory(petCategoryGenerator());
        petModel.setTags(petTagItemGenerator());
        petModel.setStatus(petStatus.name());
        return petModel;
    }

    @Step("Check expected and actual result")
    public void checkResultPetModel(PetModel actualResponse, PetModel expectedResult) {
        PetModelAssert.assertThat(actualResponse).isEqualTo(expectedResult);
    }

    @Step("Check expected and actual result")
    public void checkErrorResponse(BadResponse actualResult, BadResponse expectedResult) {
        BadResponseAssert.assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }
}
