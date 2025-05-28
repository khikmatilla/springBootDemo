package uz.pdp.springbootdemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import uz.pdp.springbootdemo.auditing.SessionUser;
import uz.pdp.springbootdemo.post.Post;
import uz.pdp.springbootdemo.post.PostRepository;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootDemoApplication {

    private final SessionUser sessionUser;

    public SpringBootDemoApplication(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    //@Bean
    ApplicationRunner applicationRunner(PostRepository postRepository, ObjectMapper objectMapper) {
        return args -> {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            List<Post>posts = objectMapper.readValue(url, new TypeReference<>() {
            });
            postRepository.saveAll(posts);
        };
    }

    @Bean
    AuditorAware<Long>auditorAware(){
        return () -> Optional.ofNullable(sessionUser.getId());
    }
}
