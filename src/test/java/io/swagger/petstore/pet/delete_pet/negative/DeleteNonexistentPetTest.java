package io.swagger.petstore.pet.delete_pet.negative;


import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.models.pet.PetModel;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;

public class DeleteNonexistentPetTest extends PetDataGenerator {

    @Test
    public void deleteNonexistentPet() {

        PetModel testPet = petModelRandomGenerator(PetStatus.available);

        PetController petController = new PetController(testPet);
        petController.addNewPet();
        petController.deletePet(200);
        petController.deletePet(404);
    }
}
