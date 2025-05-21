package uz.pdp.springbootdemo.jsonNode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class JsonNodeTest {

    @Test
    void test() throws Exception {
        String jsonNode = """
                {
                    "id": 1,
                    "name": "Leanne Graham",
                    "username": "Bret",
                    "email": "Sincere@april.biz",
                    "address": {
                      "street": "Kulas Light",
                      "suite": "Apt. 556",
                      "city": "Gwenborough",
                      "zipcode": "92998-3874",
                      "geo": {
                        "lat": "-37.3159",
                        "lng": "81.1496"
                      }
                    },
                    "phone": "1-770-736-8031 x56442",
                    "website": "hildegard.org",
                    "company": {
                      "name": "Romaguera-Crona",
                      "catchPhrase": "Multi-layered client-server neural-net",
                      "bs": "harness real-time e-markets"
                    }
                  }
                """;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonNode);
        System.out.println("rootNode.get(\"id\").asLong() = " + rootNode.get("id").asLong());
        System.out.println("rootNode.get(\"address/geo/lat\").asDouble() = " + rootNode.at("/address/geo/lat").asDouble());
    }

    @Test
    void traverseRootTest() throws JsonProcessingException {
        String jsonNode = """
                {
                    "id": 1,
                    "name": "Leanne Graham",
                    "username": "Bret",
                    "email": "Sincere@april.biz",
                    "address": {
                      "street": "Kulas Light",
                      "suite": "Apt. 556",
                      "city": "Gwenborough",
                      "zipcode": "92998-3874",
                      "geo": {
                        "lat": "-37.3159",
                        "lng": "81.1496"
                      }
                    },
                    "phone": "1-770-736-8031 x56442",
                    "website": "hildegard.org",
                    "company": {
                      "name": "Romaguera-Crona",
                      "catchPhrase": "Multi-layered client-server neural-net",
                      "bs": "harness real-time e-markets"
                    }
                  }
                """;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonNode);
        traverse(rootNode);
    }

    void traverse(JsonNode rootNode) {
        if (rootNode.isObject()) {
            Iterator<String> fieldNames = rootNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode jsonNode = rootNode.get(fieldName);
                traverse(jsonNode);
            }
        } else if (rootNode.isArray()) {
            for (JsonNode jsonNode : rootNode) {
                traverse(jsonNode);
            }
        }else
            System.out.println(rootNode.asText());
    }
}
