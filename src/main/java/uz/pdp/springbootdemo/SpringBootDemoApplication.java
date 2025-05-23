package uz.pdp.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uz.pdp.springbootdemo.book.Book;
import uz.pdp.springbootdemo.book.BookRepository;
import uz.pdp.springbootdemo.config.ApplicationConfigurer;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringBootDemoApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfigurer.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);
        Book book = Book.builder()
                .name("Spring Boot")
                .author("James Bond")
                .build();
        bookRepository.save(book);
    }
}
