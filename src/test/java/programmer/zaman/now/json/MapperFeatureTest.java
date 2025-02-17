package programmer.zaman.now.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapperFeatureTest {

    @Test
    void mapperFeature() throws JsonProcessingException {
        String json = """
                {"ID": "1", "Name": "Sony"}
                """;
        ObjectMapper objectMapper = new ObjectMapper().configure(
                MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true
        );
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Sony", person.getName());
    }

    @Test
    void deserializationFeature() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        String json = """
                {"ID": "1", "Name": "Sony", "age": 30, "hobbies": ["Coding"]}
                """;

        Person person = objectMapper.readValue(json, Person.class);
        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Sony", person.getName());
        Assertions.assertEquals(List.of("Coding"), person.getHobbies());
    }
}
