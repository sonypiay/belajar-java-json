package programmer.zaman.now.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {

    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstname", "Sony",
                "lastname", "Darmawan",
                "age", 28,
                "married", false,
                "address", Map.of(
                        "street", "Jalanin aja dulu",
                        "city", "Jakarta",
                        "country", "Indonesia"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }
}
