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
//        Book book = Book.builder()
//                .name("Database Design Patterns")
//                .author("Lok")
//                .build();
//        bookRepository.save(book);
        bookRepository.findAll().forEach(System.out::println);
        bookRepository.findById(1L).ifPresentOrElse(System.out::println, () -> {
            System.out.println("Book not found");
        });
        bookRepository.deleteById(2L);

    }
}
