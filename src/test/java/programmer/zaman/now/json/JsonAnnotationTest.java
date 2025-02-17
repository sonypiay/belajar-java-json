package programmer.zaman.now.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class JsonAnnotationTest {

    @Test
    void annotation() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);

        Person person = new Person();
        person.setId("1");
        person.setName("Sony");
        person.setFullName("Sony Darmawan");
        person.setPassword("rahasia");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
