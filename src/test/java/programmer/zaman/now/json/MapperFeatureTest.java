package programmer.zaman.now.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
