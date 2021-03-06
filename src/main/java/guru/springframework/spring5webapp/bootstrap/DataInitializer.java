package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.jpa.domain.Book;
import guru.springframework.spring5webapp.jpa.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataInitializer");
        //        Book bookDDD = new Book("domain driven design", "123", "RandomHouse",  UUID.randomUUID());
        //        Book saveDDD = bookRepository.save(bookDDD);
        //
        //        Book bookSIA = new Book("Spring in action", "456", "OReily",  UUID.randomUUID());
        //        Book saveSIA = bookRepository.save(bookSIA);

        //        System.out.println(saveDDD.getId());
        //        System.out.println(saveSIA.getId());
        List<Book> books = bookRepository.findAll();
        books.forEach(book -> {
            System.out.println("book :" + book.getId() + " " + book.getTitle() + " " + book.getAuthorId());
        });
    }
}
