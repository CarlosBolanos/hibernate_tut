package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.jpa.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5webappApplication {

    @Autowired
    private static BookRepository bookRepository;

	public static void main(String[] args) {
        SpringApplication.run(Spring5webappApplication.class, args);
	}
}
