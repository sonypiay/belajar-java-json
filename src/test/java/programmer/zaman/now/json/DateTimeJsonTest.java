package programmer.zaman.now.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeJsonTest {

    @Test
    void dateTime() throws JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("1");
        person.setName("Sony");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
