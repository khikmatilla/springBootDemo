package uz.pdp.springbootdemo.tasks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uz.pdp.springbootdemo.objectMapper.Post;

import java.util.List;

public class JsonCar {

    @Test
    void testJsonCar() throws Exception {
        String json = """
                 [
                  {
                  "type": "car",
                  "model": "jentra",
                  "color": "white"
                  },
                  {
                  "type": "truck",
                  "model": "MAN",
                  "color": "white"
                  },
                  {
                  "type": "truck",
                  "model": "zil-130",
                  "color": "blue"
                  }
                  ]
                """;

        ObjectMapper mapper = new ObjectMapper();
        List<Car> cars = mapper.readValue(json, new TypeReference<List<Car>>() {
        });
        for (Car car : cars) {
            System.out.println(car);
        }

        Car car = new Car();
        car.setType("car");
        car.setModel("jentra");
        car.setColor("white");
        String writeValueAsString = mapper.writeValueAsString(car);
        System.out.println(writeValueAsString);

    }

    @Test
    public void unknownFieldExceptionTest() throws Exception {
        String postJson = """
                 {
                "type": "truck",
                "model": "zil-130",
                "year": "blue"
                }
                """;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car car = mapper.readValue(postJson, Car.class);
        System.out.println(car);
    }
}
