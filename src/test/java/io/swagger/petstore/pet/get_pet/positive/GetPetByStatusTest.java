package io.swagger.petstore.pet.get_pet.positive;

import io.swagger.petstore.controllers.pet.PetController;
import io.swagger.petstore.pet.PetDataGenerator;
import io.swagger.petstore.utils.PetStatus;
import org.junit.Test;


public class GetPetByStatusTest extends PetDataGenerator {

    @Test
    public void getPetsWithAvailableStatus(){
        test(PetStatus.available);
    }

    @Test
    public void getPetsWithPendingStatus(){
        test(PetStatus.pending);
    }

    @Test
    public void getPetsWithSoldStatus(){
        test(PetStatus.sold);
    }


    private void test(PetStatus petStatus) {

        new PetController().getPetByStatus(petStatus);
    }
}
