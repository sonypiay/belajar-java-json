package programmer.zaman.now.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanTest {

    @Test
    void createJsonFromObject() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Sony");
        person.setHobbies(List.of("Badminton", "Country"));

        Address address = new Address();
        address.setCity("Jakarta");
        address.setCountry("Indonesia");
        address.setStreet("Jalanin aja dulu");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {
        String json = """
        {"id":"1","name":"Sony","hobbies":["Badminton","Country"],"address":{"street":"Jalanin aja dulu","city":"Jakarta","country":"Indonesia"}}
        """;

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Sony", person.getName());
        Assertions.assertEquals("Jakarta",person.getAddress().getCity());
        Assertions.assertEquals("Indonesia", person.getAddress().getCountry());
    }
}
