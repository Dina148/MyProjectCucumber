package API;

import API.pogo.PetPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Serialization {

    @Test
    public void serializationTest() throws IOException {
        PetPojo pet=new PetPojo();
        pet.setName("Rex1");
        pet.setId(2023);
        pet.setStatus("AAAA");
        pet.setCategory(null);

        ObjectMapper objectMapper=new ObjectMapper();
        File jsonFile=new File("src/test/resources/pet.json");
        objectMapper.writeValue(jsonFile, pet);



    }
}
