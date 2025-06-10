package uz.pdp.springbootdemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uz.pdp.springbootdemo.comment.CommentRepository;
import uz.pdp.springbootdemo.post.Post;
import uz.pdp.springbootdemo.post.PostRepository;
import uz.pdp.springbootdemo.todo.Todo;
import uz.pdp.springbootdemo.todo.TodoRepository;
import uz.pdp.springbootdemo.comment.Comment;

import java.net.URL;
import java.util.List;

//@OpenAPIDefinition(
//        info = @Info(
//                title = "Spring 6 Swagger With Annotation Config",
//                version = "1.0.1",
//                contact = @Contact(
//                        name = "Habibullayev Hikmatilla",
//                        email = "hikmatilla1999.@gmail.com",
//                        url = "https://github.com/khikmatilla"
//                ),
//                license = @License(
//                        name = "Apache 2.0",
//                        url = "https://springdoc.org"),
//                termsOfService = "http://swagger.io/terms/",
//                description = "Spring 6 Swagger Simple Application"
//        ),
//        externalDocs = @ExternalDocumentation(
//                description = "Spring 6 Wiki Documentation",
//                url = "https://springshop.wiki.github.org/docs"
//        ),
//        servers = {
//                @Server(
//                        url = "http://localhost:8080",
//                        description = "Production-Server"
//                ),
//                @Server(
//                        url = "http://localhost:9090",
//                        description = "Test-Server"
//                )
//        }
//)
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    // @Bean
    public CommandLineRunner runner(
            ObjectMapper objectMapper,
            PostRepository postRepository,
            TodoRepository todoRepository,
            CommentRepository commentRepository) {

        return args -> {
            List<Post> posts = objectMapper.readValue(
                    new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<>() {
                    });
            postRepository.saveAll(posts);

            List<Todo> todos = objectMapper.readValue(
                    new URL("https://jsonplaceholder.typicode.com/todos"), new TypeReference<>() {
                    });
            todoRepository.saveAll(todos);

            List<Comment> comments = objectMapper.readValue(
                    new URL("https://jsonplaceholder.typicode.com/comments"), new TypeReference<>() {
                    });
            commentRepository.saveAll(comments);
        };
    }
    static class Config {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").allowedOrigins("*");
                }
            };
        }
    }
}
