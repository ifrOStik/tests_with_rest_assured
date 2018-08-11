package io.swagger.petstore.pet;

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

    public PetModel petModelRandomGenerator(PetStatus petStatus) {
        PetModel petModel = new PetModel();
        petModel.setId(petIdGenerator());
        petModel.setPhotoUrls(petPhotoUrlGenerator());
        petModel.setName(petNameGenerator());
        petModel.setStatus(petStatus.name());
        return petModel;
    }

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
}
