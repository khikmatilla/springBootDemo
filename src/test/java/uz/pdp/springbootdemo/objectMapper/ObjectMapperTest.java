package uz.pdp.springbootdemo.objectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public class ObjectMapperTest {


    public static final String JSON = """
            [
              {
                "userId": 1,
                "id": 1,
                "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
              },
              {
                "userId": 1,
                "id": 2,
                "title": "qui est esse",
                "body": "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla"
              },
              {
                "userId": 1,
                "id": 3,
                "title": "ea molestias quasi exercitationem repellat qui ipsa sit aut",
                "body": "et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut"
              },
              {
                "userId": 1,
                "id": 4,
                "title": "eum et est occaecati",
                "body": "ullam et saepe reiciendis voluptatem adipisci\\nsit amet autem assumenda provident rerum culpa\\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\\nquis sunt voluptatem rerum illo velit"
              },
              {
                "userId": 1,
                "id": 5,
                "title": "nesciunt quas odio",
                "body": "repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque"
              },
              {
                "userId": 1,
                "id": 6,
                "title": "dolorem eum magni eos aperiam quia",
                "body": "ut aspernatur corporis harum nihil quis provident sequi\\nmollitia nobis aliquid molestiae\\nperspiciatis et ea nemo ab reprehenderit accusantium quas\\nvoluptate dolores velit et doloremque molestiae"
              },
              {
                "userId": 1,
                "id": 7,
                "title": "magnam facilis autem",
                "body": "dolore placeat quibusdam ea quo vitae\\nmagni quis enim qui quis quo nemo aut saepe\\nquidem repellat excepturi ut quia\\nsunt ut sequi eos ea sed quas"
              },
              {
                "userId": 1,
                "id": 8,
                "title": "dolorem dolore est ipsam",
                "body": "dignissimos aperiam dolorem qui eum\\nfacilis quibusdam animi sint suscipit qui sint possimus cum\\nquaerat magni maiores excepturi\\nipsam ut commodi dolor voluptatum modi aut vitae"
              }
              ]
            """;

    @Test
    public void test() throws JsonProcessingException {
        String postJson = """
                {
                "userId": 1,
                "id": 1,
                "title": "Tolov va xizmatlar uchun",
                "body": "Ushbu user humo bank kartasidan market xizmatlar uchun pul otkazdi"
                }
                """;
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(postJson, Post.class);
        System.out.println(post);
        String writtenValueAsString = mapper.writeValueAsString(post);
        System.out.println(writtenValueAsString);
    }

    @Test
    public void objectFromStringReader() throws Exception {
        String postJson = """
                {
                "userId": 1,
                "id": 1,
                "title": "Tolov va xizmatlar uchun",
                "body": "Ushbu user humo bank kartasidan market xizmatlar uchun pul otkazdi"
                }
                """;
        StringReader stringReader = new StringReader(postJson);
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(stringReader, Post.class);
        System.out.println("post.getTitle() = " + post.getTitle());
    }

    @Test
    public void objectFromFile() throws Exception {
        File file = new File("data/file.txt");
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(file, Post.class);
        System.out.println("post.getTitle() = " + post.getTitle());
    }

    @Test
    public void objectFromUrl() throws Exception {
        int nextInt = new Random().nextInt(1, 15);
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/" + nextInt);
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(url, Post.class);
        System.out.println(post);
    }

    @Test
    public void listFromStringArray() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Post> posts = mapper.readValue(JSON, new TypeReference<List<Post>>() {
        });
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void mapFromStringJson() throws Exception {
        String postJson = """
                {
                "userId": 1,
                "id": 1,
                "title": "Tolov va xizmatlar uchun",
                "body": "Ushbu user humo bank kartasidan market xizmatlar uchun pul otkazdi"
                }
                """;
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> keyValues = mapper.readValue(postJson, new TypeReference<Map<String, String>>() {
        });
        System.out.println(keyValues);
    }

    @Test
    public void unknownFieldExceptionTest() throws Exception {
        String postJson = """
                {
                "userId": 1,
                "id": 1,
                "title": "Tolov va xizmatlar uchun",
                "content": "Ushbu user humo bank kartasidan market xizmatlar uchun pul otkazdi"
                }
                """;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Post post = mapper.readValue(postJson, Post.class);
        System.out.println(post);
    }

    @Test
    public void jsonFromObject() throws Exception {
        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("Tolov va xizmatlar uchun");
        post.setBody("Ushbu user humo bank kartasidan market xizmatlar uchun pul otkazdi");
        ObjectMapper mapper = new ObjectMapper();
        OutputStream outputStream = new FileOutputStream("data/serialize.json");
        mapper.writeValue(outputStream, post);
    }

    @Test
    public void yamlFormat() throws Exception {
        YAMLFactory yamlFactory = new YAMLFactory();
        ObjectMapper mapper = new ObjectMapper(yamlFactory);

        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("Tolov va xizmatlar uchun");
        post.setBody("Ushbu user humo bank kartasidan market xizmatlar uchun pul otkazdi");

        String valueAsString = mapper.writeValueAsString(post);
        System.out.println(valueAsString);

        Settings settings = mapper.readValue(new File("data/settings.yaml"), Settings.class);
        System.out.println(settings);
    }


}
