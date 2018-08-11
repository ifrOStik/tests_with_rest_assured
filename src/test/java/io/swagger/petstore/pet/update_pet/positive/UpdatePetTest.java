package io.swagger.petstore.pet.update_pet.positive;

import io.swagger.petstore.assertions.pet.PetModelAssert;
import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;


public class UpdatePetTest extends PetDataGenerator {

    @Test
    public void updatePetTest() {

        PetModel pet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController();
        petController.addNewPet(pet);

        pet.setStatus(PetStatus.sold.name());
        pet.setName(RandomStringUtils.randomAlphanumeric(6));
        pet.setPhotoUrls(petPhotoUrlGenerator());

        PetModel petResponse = petController.updatePet(pet);

        PetModelAssert.assertThat(petResponse).isEqualTo(pet);
    }
}
