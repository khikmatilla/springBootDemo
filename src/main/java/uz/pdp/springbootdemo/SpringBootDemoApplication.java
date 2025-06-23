package uz.pdp.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.pdp.springbootdemo.currentUser.CurrentUserProperties;

@SpringBootApplication
@EnableConfigurationProperties({CurrentUserProperties.class})
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
