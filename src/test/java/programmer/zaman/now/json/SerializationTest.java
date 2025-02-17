package programmer.zaman.now.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SerializationTest {

    @Test
    void serializationFeature() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Sony");
        person.setHobbies(List.of("Badminton", "Country"));

        Address address = new Address();
        address.setCity("Jakarta");
        address.setCountry("Indonesia");
        address.setStreet("Jalanin aja dulu");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void serializationInclusion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person person = new Person();
        person.setId("1");
        person.setName("Sony");

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
