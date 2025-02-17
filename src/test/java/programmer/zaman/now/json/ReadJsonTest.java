package programmer.zaman.now.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ReadJsonTest {

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
         {"address":{"city":"Jakarta","country":"Indonesia","street":"Jalanin aja dulu"},"lastname":"Darmawan","married":false,"age":28,"firstname":"Sony"}
         """;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        System.out.println(person);

        Assertions.assertEquals("Sony", person.get("firstname"));
        Assertions.assertEquals("Darmawan", person.get("lastname"));
    }
}
