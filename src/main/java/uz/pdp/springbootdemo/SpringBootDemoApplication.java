package uz.pdp.springbootdemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.pdp.springbootdemo.comment.Comment;
import uz.pdp.springbootdemo.comment.CommentRepository;
import uz.pdp.springbootdemo.post.Post;
import uz.pdp.springbootdemo.post.PostRepository;
import uz.pdp.springbootdemo.todo.Todo;
import uz.pdp.springbootdemo.todo.TodoRepository;

import java.net.URL;
import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            PostRepository postRepository,
            TodoRepository todoRepository,
            CommentRepository commentRepository,
            ObjectMapper objectMapper
    ) {

        return args -> {
           List<Post> posts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<>() {});
           postRepository.saveAll(posts);

           List<Todo> todos = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos"), new TypeReference<>() {});
           todoRepository.saveAll(todos);

           List<Comment> comments = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/comments"), new TypeReference<>() {});
           commentRepository.saveAll(comments);


        };
    }
}
